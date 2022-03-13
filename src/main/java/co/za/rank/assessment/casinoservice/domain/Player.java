package co.za.rank.assessment.casinoservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@Entity
@EqualsAndHashCode(exclude = {"transactions"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "PLAYER")
public class Player {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private BigDecimal balance;
    @ToString.Exclude
   @OneToMany(fetch = FetchType.LAZY,mappedBy = "player")
    private List<Transaction> transactions ;

}
