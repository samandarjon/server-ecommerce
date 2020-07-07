package uz.pdp.ecommerce.utils;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import uz.pdp.ecommerce.exceptions.Forbidden;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandling {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UsernameNotFoundException.class})
    public ApiResponse handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new ApiResponse(e.getMessage(), 401);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ApiResponse handleUsernameNotFoundException(NotFoundException e) {
        System.out.println(e.getMessage());
        return new ApiResponse(e.getMessage(), 404);
    }

    @ExceptionHandler({Forbidden.class})
    public ApiResponse handleForbiddenException(Forbidden e){
        System.out.println(e.getMessage());
        return new ApiResponse(e.getMessage(), 403);
    }
}

