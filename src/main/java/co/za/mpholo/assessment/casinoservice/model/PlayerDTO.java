package co.za.mpholo.assessment.casinoservice.model;

import co.za.mpholo.assessment.casinoservice.domain.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@Data
@EqualsAndHashCode(exclude = {"transactions"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO {

    @NotEmpty(message = "first name is required")
    private String firstName;
    @NotEmpty(message = "last name is required")
    private String lastName;
    @NotEmpty(message = "email name is required")
    @Email(message = "Email should be valid")
    private String email;
    private BigDecimal balance;
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();

}
