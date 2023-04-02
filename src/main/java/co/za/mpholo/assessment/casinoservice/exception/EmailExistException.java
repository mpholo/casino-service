package co.za.mpholo.assessment.casinoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by  : Mpholo Leboea on 2022/07/27
 **/

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailExistException extends Exception {

    public EmailExistException(String message) {
        super(message);
    }
}
