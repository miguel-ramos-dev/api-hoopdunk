package com.hoopdunk.api_hoopdunk.service;

import com.hoopdunk.api_hoopdunk.domain.User;
import com.hoopdunk.api_hoopdunk.dto.user.CreateUserDto;
import com.hoopdunk.api_hoopdunk.dto.user.UpdateUserDto;
import com.hoopdunk.api_hoopdunk.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //poder usar o mockito
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks //criando instancia com os mocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor; //com isso eu consigo ver os argumentos que foram passados e validar-los la embaixo.

    @Captor
    private ArgumentCaptor<Integer> idArgumentCaptor; //para testar a função de pegar pelo ID

    @Nested
    class createUser {

        @Test
        void shouldCreateAUserWithSucces() {

            // Arrange
            //criando instancias do user alem de definir comportamentos e retornos dos mesmos
            var user = new User(
                    1,
                    "TesteUnitario",
                    "testeJM",
                    "ts@gmail.com",
                    "Armador",
                    "Intermediário",
                    "123",
                    "image(1).png"
            );

            //quando eu chamar o userRepository.save ele vai retornar o usuario que eu criei la em cima (teste)
            doReturn(user).when(userRepository).save(userArgumentCaptor.capture()); //capturo os argumentos que foram passados para os save

            //Usuario que vou enviar para ser "criado"
            var input = new CreateUserDto(
                    "TesteUnitario",
                    "testeJM",
                    "ts@gmail.com",
                    "123"
            );

            //Act
            var output = userService.createUser(input);

            //Assert
            var userCaptured = userArgumentCaptor.getValue(); //pegando valores que o argumentCaptor capturou la em cima

            assertNotNull(output);
            assertEquals(input.nome(), userCaptured.getNome()); //consigo comparar o que eu mandei p/ metodo e o que chegou la dentro
            assertEquals(input.email(), userCaptured.getEmail()); //consigo comparar o que eu mandei p/ metodo e o que chegou la dentro
        }

        @Test
        @DisplayName("Should thwor exception when error occurs") //só p ficar bonitinho
        void shouldThrowExceptionWhenErrorOccurs() {
            // Arrange

            //quando eu chamar o userRepository.save ele vai retornar uma exception
            doThrow(new RuntimeException()).when(userRepository).save(any());
            var input = new CreateUserDto(
                    "TesteUnitario",
                    "testeJM",
                    "ts@gmail.com",
                    "123"
            );

            //Act & Assert

            //Primeiro argumento é o tipo de exceção que eu quero que ele lance
            assertThrows(RuntimeException.class, () -> userService.createUser(input)); //não veio nulo, veio alguma coisa
        }
    }

    @Nested
    class getUserById {

        @Test
        void shouldGetUserWithSuccessWhenOptionalIsPresent() {

            //Arrange
            var user = new User(
                    1,
                    "TesteUnitario",
                    "testeJM",
                    "ts@gmail.com",
                    "Armador",
                    "Intermediário",
                    "123",
                    "image(1).png"
            );
            doReturn(Optional.of(user)).when(userRepository).findById(idArgumentCaptor.capture());

            //Act
            var output = userService.getUserById(user.getId());

            //Assert
            assertTrue(output.isPresent());//se tem usuario (pq o Optional pode trazer o usuário ou nao né)
            assertEquals(user.getId(), idArgumentCaptor.getValue()); //caso alguem altere o código eu posso ver aq caso de erro. (mesmo esquema de cima)
        }

        @Test
        void shouldGetUserWithSuccessWhenOptionalIsEmpty() {

            //Arrange
            Integer userId = 1;

            //Optional.empty retorna porra nenhuma
            doReturn(Optional.empty()).when(userRepository).findById(idArgumentCaptor.capture());

            //Act
            var output = userService.getUserById(userId);

            //Assert
            assertTrue(output.isEmpty());//se tem usuario (pq o Optional pode trazer o usuário ou nao né)
            assertEquals(userId, idArgumentCaptor.getValue()); //caso alguem altere o código eu posso ver aq caso de erro. (mesmo esquema de cima)
        }
    }

    @Nested
    class listUsers { //all users

        @Test
        @DisplayName("Should return all users with sucess")
        void shouldReturnAllUsersWithSuccess() {
            //Arrange
            var user = new User(
                    1,
                    "TesteUnitario",
                    "testeJM",
                    "ts@gmail.com",
                    "Armador",
                    "Intermediário",
                    "123",
                    "image(1).png"
            );
            var userList = List.of(user); //cria lista de usuários, no caso só tem um usuario na lista

            doReturn(List.of(user)).when(userRepository).findAll();

            //Act
            var output = userService.listUsers();

            //Assert
            assertNotNull(output);
            assertEquals(userList.size(),output.size());
        }

    }

    @Nested
    class deleteById {

        @Test
        void shouldDeleteUserWithSuccessWhenUserExists() {

            //Arrange
            var userId = 3;
            doReturn(true).when(userRepository).existsById(idArgumentCaptor.capture()); //funcao do exists by id

            doNothing().when(userRepository).deleteById(idArgumentCaptor.capture()); //funcao mocada do deleteBydId(por que é Void o retorno la)

            //Act
            userService.deleteById(userId);


            //Assert
            var idList = idArgumentCaptor.getAllValues(); //já que usamos 2 vezes, ele cria uma lista

            //verificamos se o que passamos é de fato o que passamos caso haja erro no código/alteração na lógica
            assertEquals(userId, idList.get(0)); //pegamos os valores da lista em ordem de uso
            assertEquals(userId, idList.get(1));

            //verifica se os métodos foram chamados corretamente durante a execução do método pai
            verify(userRepository, times(1)).existsById(idList.get(0));
            verify(userRepository, times(1)).deleteById(idList.get(1));

        }

        @Test
        void shouldNotDeleteUserWithSuccessWhenUserNotExists() {

            //Arrange
            var userId = 3;
            doReturn(false).when(userRepository).existsById(idArgumentCaptor.capture()); //funcao do exists by id

            //já que o metodo nem vai chegar a excluir eu tirei a "mocagem" do metodo.


            //Act
            userService.deleteById(userId);

            //Assert

            //verificamos se o que passamos é de fato o que passamos caso haja erro no código/alteração na lógica
            assertEquals(userId, idArgumentCaptor.getValue()); //pegamos os valores da lista em ordem de uso


            verify(userRepository, times(1)).existsById(idArgumentCaptor.getValue());
            //podemos usar o any quando o metodo nem for chamado, que é o objetivo aqui
            verify(userRepository, times(0)).deleteById(any());

        }

    }

    @Nested
    class updateUserById {

        @Test
        void shouldUpdateAUserWhenUserExistsAndDataExistsToo() {
            //Arrange
            var user = new User(
                    5,
                    "TesteUnitario",
                    "testeJM",
                    "ts@gmail.com",
                    "Armador",
                    "Intermediário",
                    "123",
                    "image(1).png"
            );

            var updateUserDto = new UpdateUserDto (
                    "TesteAtualizado",
                    "testeUPDT",
                    "tsUPDT@gmail.com",
                    "Viadinho",
                    "Pivô",
                    "Profissional"
            );

            //pode ou nao trazer um usuario
            doReturn(Optional.of(user))
                    .when(userRepository)
                    .findById(idArgumentCaptor.capture());

            doReturn(user)
                    .when(userRepository)
                    .save(userArgumentCaptor.capture());

            //Act
            userService.updateUserById(user.getId(), updateUserDto);

            //Assert

            var userCaptured = userArgumentCaptor.getValue(); //pegando os dados que foram passados pro save.

            assertEquals(user.getId(), idArgumentCaptor.getValue()); //id do usuário é o mesmo que chegou no findById
            //se os dados que eu passei realmente foram para o save
            assertEquals(updateUserDto.nome(), userCaptured.getNome());
            assertEquals(updateUserDto.posicao(), userCaptured.getPosicao());

            verify(userRepository, times(1)).findById(user.getId());
            verify(userRepository, times(1)).save(user);
        }

        @Test
        void shouldNotUpdateUserWhenUserNotExists() {
            //Arrange
            var userId = 5;

            var updateUserDto = new UpdateUserDto (
                    "TesteAtualizado",
                    "testeUPDT",
                    "tsUPDT@gmail.com",
                    "Viadinho",
                    "Pivô",
                    "Profissional"
            );

            //pode ou nao trazer um usuario
            doReturn(Optional.empty())
                    .when(userRepository)
                    .findById(idArgumentCaptor.capture());


            //Act
            userService.updateUserById(userId, updateUserDto);

            //Assert
            assertEquals(userId, idArgumentCaptor.getValue()); //id do usuário é o mesmo que chegou no findById
            verify(userRepository, times(1)).findById(userId);
            verify(userRepository,times(0)).save(any());
        }
    }





}