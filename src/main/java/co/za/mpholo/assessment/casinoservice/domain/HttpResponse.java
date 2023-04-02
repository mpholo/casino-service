package co.za.mpholo.assessment.casinoservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class HttpResponse {

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy hh:mm:ss",timezone = "Africa/Harare")
    private Date timeStamp = new Date();
    @NonNull
    private int httpStatusCode;
    @NonNull
    private HttpStatus httpStatus;
    @NonNull
    private String reason;
    @NonNull
    private String message;


}
