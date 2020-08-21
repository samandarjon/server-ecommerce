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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EcommerceApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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
        userDto.setPhoneNumber("fsdgfdsagfadsgdfshgdfsgg");
        userDto.setPassword("test123");
        userDto.setPassword2("test123");
        MatcherAssert.assertThat(
                restTemplate.postForObject("http://localhost:" + port + "/api/auth/register",
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
        userDto.setPhoneNumber("fsdgfdsagfadsgdfshgdfsgg");
        userDto.setPassword("test123");
        userDto.setPassword2("test123");
        MatcherAssert.assertThat(
                restTemplate.postForObject("http://localhost:" + port + "/api/auth/register",
                        userDto, ApiResponse.class).getStatus(),
                Matchers.equalTo(400));

    }


}
