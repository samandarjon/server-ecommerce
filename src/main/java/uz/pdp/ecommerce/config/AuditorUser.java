package uz.pdp.ecommerce.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.pdp.ecommerce.entity.User;

import java.util.Optional;
import java.util.UUID;

@Configuration
@EnableJpaAuditing
public class AuditorUser {
    @Bean
    AuditorAware<UUID> whoIs() {
        return new WhoIs();
    }

}

class WhoIs implements AuditorAware<UUID> {
    @NotNull
    @Override
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication == null
                || !authentication.isAuthenticated()
                || "anonymousUser".equals(authentication.getPrincipal()))) {
            User user = (User) authentication.getPrincipal();
            return Optional.of(user.getId());
        }
        return Optional.empty();
    }
}
