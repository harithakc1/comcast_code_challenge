import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.src.UserInputDTO;
import org.src.usercontroller.UserController;
import org.src.userservice.UserService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserController.class)
@EnableSpringDataWebSupport
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @InjectMocks
    private UserController userController;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;
    private static final Long MOCK_USER_ID = 122L;

    @Test
    public void givenFindAllUsers() {
        given(userService.findAllUsers()).willReturn(List.of());
        assertThatCode(() -> userController.findAllUsers()).doesNotThrowAnyException();
    }

    public void givenCreateNewUser() throws Exception {
        given(userService.createUser(any())).willReturn(UserInputDTO.builder().build());

        this.mockMvc.perform(post("/user/create")
                        .content(objectMapper.writeValueAsString(UserInputDTO.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public void givenUpdateExistingUser() throws Exception {
        given(userService.updateUser(any())).willReturn(UserInputDTO.builder().build());
        this.mockMvc.perform(patch("user/update/{id}")
                        .content(objectMapper.writeValueAsString(MOCK_USER_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public void givenDeleteExistingUser() throws Exception {
        doNothing().when(userService).deleteUser(MOCK_USER_ID);
        assertThatCode(() -> userController.deleteUser(MOCK_USER_ID)).doesNotThrowAnyException();
        this.mockMvc.perform(delete("user/update/{id}")
                        .content(objectMapper.writeValueAsString(MOCK_USER_ID))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
