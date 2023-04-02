package co.za.mpholo.assessment.casinoservice.exception;

import co.za.mpholo.assessment.casinoservice.domain.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@RestControllerAdvice
@Slf4j
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    private static final String METHOD_IS_NOT_ALLOWED="This request method is not allowed on this endpoint. Please send a %s request";
    private static final String INTERAL_SERVER_ERROR_MSG="An error occurred while processing the request";
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<HttpResponse> playerNotFoundException(PlayerNotFoundException e) {
        return createHttpResponse(HttpStatus.NOT_FOUND,e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        final ResponseEntity<HttpResponse> httpResponse = createHttpResponse(METHOD_NOT_ALLOWED, ex.getMessage());
        return new ResponseEntity(httpResponse.getBody(), METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(PlayerExistsException.class)
    public ResponseEntity<HttpResponse> playerExistsException(PlayerExistsException e) {
        log.error(e.getMessage());
        return createHttpResponse(BAD_REQUEST,e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

      Map<String,String> errors = new HashMap<>();
      ex.getBindingResult().getAllErrors()
              .forEach((error)->{
                  final String fieldName = ((FieldError) error).getField();
                  final String message =error.getDefaultMessage();
                  errors.put(fieldName,message);
              });

      return new ResponseEntity<>(errors, BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerErrorException(Exception e) {
        log.error(e.getMessage());
        String message = e.getMessage()==null?INTERAL_SERVER_ERROR_MSG:e.getMessage();
        return createHttpResponse(INTERNAL_SERVER_ERROR,message);
    }


    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {

        HttpResponse httpResponse = new HttpResponse(httpStatus.value(),httpStatus,
                httpStatus.getReasonPhrase().toUpperCase()
                ,message);

        return new ResponseEntity<>(httpResponse, httpStatus);
    }

}
