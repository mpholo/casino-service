package co.za.mpholo.assessment.casinoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String s) {
        super(s);
    }
}
