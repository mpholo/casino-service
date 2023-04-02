package co.za.mpholo.assessment.casinoservice.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@Entity
@EqualsAndHashCode(exclude = {"transactions","balance"})
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
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal balance;
    @ToString.Exclude
   @OneToMany(fetch = FetchType.LAZY,mappedBy = "player")
    private List<Transaction> transactions ;

}
