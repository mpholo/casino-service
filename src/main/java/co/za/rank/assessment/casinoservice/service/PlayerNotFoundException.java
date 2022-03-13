package co.za.rank.assessment.casinoservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String s) {
        super(s);
    }
}
