package pcf.jjs.project_community_finder_server.Users.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UsersErrorHandling {


    /**
     * Handles Validation error. Puts entity fields and error into a map and sends back a Bad_Request code
     * @param ex the error that is thrown by @Valid
     * @return error map that gets parsed into json when sent
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        System.out.println(ex.getBindingResult().getFieldErrors().size());
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return errorMap;
    };

    /**
     * Handles Error when an account name already exist in the database and sends back a Conflict code
     * @return error map that gets parsed into json when sent
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityExistsException.class)
    public Map<String, String> handleConflictUsername(){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error","Account name already exist");
        return errorMap;
    };

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, String> userNotFound(){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "some error");
        return errorMap;
    }
}
