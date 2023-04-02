package co.za.mpholo.assessment.casinoservice.model;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.domain.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/



@Data
@EqualsAndHashCode(exclude = {"player","type"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDTO {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long transactionId;
    private BigDecimal amount;
    private TransactionType type;
    private Date creationDate;
    @JsonIgnore
    private Player player;

}
