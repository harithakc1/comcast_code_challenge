import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.src.UserInputDTO;
import org.src.entity.User;
import org.src.repository.UserRepository;
import org.src.userservice.UserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserService.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private static final Long MOCK_USER_ID = 122L;

    private User newUserEntity() {
        return new User();
    }

    private UserInputDTO newUserInputDTO() {
        return UserInputDTO.builder().build();
    }

    @Test
    public void givenUserInputWhenToCreateUserThenCreateSuccessfully() {
        given(userRepository.save(any())).willReturn(newUserEntity());
        assertThatCode(() -> userService.createUser(newUserInputDTO())).doesNotThrowAnyException();
        verify(userRepository).save(any());
    }

    @Test
    public void givenUserIdWhenToUpdateUserThenUpdateSuccessfully() {
        given(userRepository.findById(MOCK_USER_ID)).willReturn(Optional.of(any()));
        given(userRepository.save(any())).willReturn(newUserEntity());
        assertThatCode(() -> userService.updateUser(MOCK_USER_ID)).doesNotThrowAnyException();

        verify(userRepository).findById(any());
        verify(userRepository).save(any());
    }

    @Test
    public void givenUserIdWhenToDeleteUserThenDeleteSuccessfully() {
        given(userRepository.findById(MOCK_USER_ID)).willReturn(Optional.of(any()));
        doNothing().when(userRepository).delete(any());
        assertThatCode(() -> userService.deleteUser(MOCK_USER_ID)).doesNotThrowAnyException();

        verify(userRepository).findById(any());
        verify(userRepository).delete(any());
    }

    @Test
    public void givenFindAllUsersThenFindUsersSuccessfully() {
        given(userRepository.findAll()).willReturn(List.of(any()));
        assertThatCode(() -> userService.findAllUsers()).doesNotThrowAnyException();

        verify(userRepository).findAll();
    }
}
