package uz.pdp.ecommerce.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final Integer CACHE_PERIOD = 86400*10;

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/", "classpath:/META-INF/resources/webjars/"};


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "DELETE", "PUT");
    }
    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/static")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS).setCachePeriod(CACHE_PERIOD);
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS).setCachePeriod(CACHE_PERIOD);
    }



}
