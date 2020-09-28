package uz.pdp.ecommerce;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.CreateUserDto;
import uz.pdp.ecommerce.payload.LoginUser;
import uz.pdp.ecommerce.payload.TokenResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthTests {
    @LocalServerPort
    private int port;


    private final TestRestTemplate restTemplate;
    private final String host;

    @Autowired
    AuthTests(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.host = "http://localhost:";
    }

    /**
     * @desc Test for an unregistered user
     * @request_body CreateUserDto.class
     * @response_body ApiResponse.class
     */
    @Test
    public void registerUser() {
        CreateUserDto userDto = new CreateUserDto();
        userDto.setFirstName("testjon");
        userDto.setLastName("testov");
        userDto.setPhoneNumber("test123");
        userDto.setPassword("test123");
        userDto.setPassword2("test123");
        MatcherAssert.assertThat(
                restTemplate.postForObject(host + port + "/api/auth/register",
                        userDto, ApiResponse.class).getStatus(),
                Matchers.equalTo(201));

    }

    /**
     * @desc Test for an registered user
     * @request_body CreateUserDto.class
     * @response_body ApiResponse.class
     */
    @Test
    public void registerUserWithAlreadyCreatedUser() {
        CreateUserDto userDto = new CreateUserDto();
        userDto.setFirstName("testjon");
        userDto.setLastName("testov");
        userDto.setPhoneNumber("test123");
        userDto.setPassword("test123");
        userDto.setPassword2("test123");
        MatcherAssert.assertThat(
                restTemplate.postForObject(host + port + "/api/auth/register",
                        userDto, ApiResponse.class).getStatus(),
                Matchers.equalTo(400));

    }

    /**
     * @desc Test for an login user
     * @request_body LoginUser.class
     * @response_body TokenRespone.class
     */

    @Test
    public void loginUser() {
        LoginUser loginUser = new LoginUser("+998905896958", "smndr2013");
        TokenResponse tokenResponse = restTemplate.postForObject(host + port + "/api/auth/login", loginUser, TokenResponse.class);
        MatcherAssert.assertThat(tokenResponse.isSuccess(), Matchers.equalTo(true));
    }

    /**
     * @throws Any Handle Exception
     * @desc Test for an registered user with throw exception
     * @request_body LoginUser.class
     * @response_body UserNotFoundException.class
     */
    @Test
    public void loginUserWithException() {
        LoginUser loginUser = new LoginUser("kdjaflkdsjlkgfjflk", "smndr2013");
        try {
            restTemplate.postForObject(host + port + "/api/auth/login", loginUser, TokenResponse.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
