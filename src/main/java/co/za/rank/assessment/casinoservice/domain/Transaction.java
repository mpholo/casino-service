package co.za.rank.assessment.casinoservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@Entity
@EqualsAndHashCode(exclude = {"player","type"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private BigDecimal amount;
    @Enumerated(value = EnumType.STRING)
    @ToString.Exclude
    private TransactionType type;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

}
