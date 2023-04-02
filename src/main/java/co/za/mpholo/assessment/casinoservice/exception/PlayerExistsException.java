package co.za.mpholo.assessment.casinoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by  : Mpholo Leboea on 2023/04/02
 **/

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PlayerExistsException extends RuntimeException {

    public PlayerExistsException(String message) {
        super(message);
    }
}
