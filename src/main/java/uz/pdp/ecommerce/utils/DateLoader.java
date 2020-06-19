package uz.pdp.ecommerce.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.entity.enums.RoleName;
import uz.pdp.ecommerce.repository.RoleRepository;
import uz.pdp.ecommerce.repository.UserRepository;

import java.util.Collections;
import java.util.HashSet;

@Component
public class DateLoader {
    final RoleRepository roleRepository;
    final BCryptPasswordEncoder bCryptPasswordEncoder;
    final UserRepository userRepository;

    @Autowired
    public DateLoader(BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner runner() {
        return (a) -> {
            User user = new User("Samandar",
                    "Akbarov",
                    "samandar_akbarov",
                    "+998905896958",
                    bCryptPasswordEncoder.encode("smndr2013"),
                    new HashSet<>(roleRepository.findAll())
            );
            User user2 = new User("User",
                    "User",
                    "user",
                    "123456",
                    bCryptPasswordEncoder.encode("test"),
                    Collections.singleton((roleRepository.findByRoleName(RoleName.ROLE_USER)))
            );
            userRepository.save(user);
            userRepository.save(user2);
        };
    }


}
