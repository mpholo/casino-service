package co.za.mpholo.assessment.casinoservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@Entity
@EqualsAndHashCode(exclude = {"player"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    private Long transactionId;
    private BigDecimal amount;
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;
    @CreationTimestamp
    private Date creationDate;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

}
