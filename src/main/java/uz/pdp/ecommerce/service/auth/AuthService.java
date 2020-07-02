package uz.pdp.ecommerce.service.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Role;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.entity.enums.RoleName;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.CreateUserDto;
import uz.pdp.ecommerce.payload.LoginUser;
import uz.pdp.ecommerce.payload.TokenResponse;
import uz.pdp.ecommerce.repository.RoleRepository;
import uz.pdp.ecommerce.repository.UserRepository;
import uz.pdp.ecommerce.security.JwtErrors;
import uz.pdp.ecommerce.security.JwtTokenProvider;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    //    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login yoki parol hato."));
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    public ApiResponse createUser(CreateUserDto createUserDto) {

        if (!userRepository.existsByPhoneNumber(createUserDto.getPhoneNumber())) {
            if (createUserDto.getPassword().equals(createUserDto.getPassword2())) {
                User user = new User(createUserDto.getFirstName(),
                        createUserDto.getLastName(),
                        null,
                        createUserDto.getPhoneNumber(),
                        bCryptPasswordEncoder.encode(createUserDto.getPassword()),
                        Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_USER))
                );
                userRepository.save(user);
                return new ApiResponse("Foydanuvchi muvoffaqiyatli ro`yhatdan o`tdi", HttpStatus.CREATED.value());
            }
            return new ApiResponse("Tasdiqlovchi parol mos kelmadi.", HttpStatus.BAD_REQUEST.value());
        }
        return new ApiResponse("Bunday raqamlik foydalanuchi oldindan mavjud.", HttpStatus.BAD_REQUEST.value());
    }

    public TokenResponse loginUser(LoginUser loginUser) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(), loginUser.getPassword()));
            User user = userRepository.findByPhoneNumber(loginUser.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Bunday user mavjud emas"));

            String token = jwtTokenProvider.createToken(String.valueOf(user.getId()), (Set<Role>) user.getAuthorities());
            return new TokenResponse(token, true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Username yoki parol xato.");
        }
    }
}
