package sk.matusko.ecs;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sk.matusko.ecs.exceptions.InvalidState;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<InvalidState> handleAccessDeniedException(ConstraintViolationException ex, WebRequest request) {

        InvalidState invalidState = new InvalidState();

        return new ResponseEntity<>(invalidState, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}