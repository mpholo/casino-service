package co.za.rank.assessment.casinoservice.model;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.domain.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/


@Data
@EqualsAndHashCode(exclude = {"player","type"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDTO {


    private Long transactionId;
    private BigDecimal amount;
    private TransactionType type;
    private Date creationDate;
    @JsonIgnore
    private Player player;

}
