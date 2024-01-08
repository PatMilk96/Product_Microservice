package ie.atu.product_microservice;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDetails> handleValidationException(MethodArgumentNotValidException ex){
        List<ErrorDetails> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            ErrorDetails errorDetails = new ErrorDetails(fieldName, errorMessage);
            errors.add(errorDetails);
        });
        return errors;
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<ErrorDetails> handleProductNotFoundException() {
        ErrorDetails errorDetails = new ErrorDetails("Error", "Product Not Found");
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }
}
