package co.za.rank.assessment.casinoservice.model;

import co.za.rank.assessment.casinoservice.domain.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@Data
@EqualsAndHashCode(exclude = {"transactions"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {

    private Long playerId;
    private BigDecimal balance;
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();

}
