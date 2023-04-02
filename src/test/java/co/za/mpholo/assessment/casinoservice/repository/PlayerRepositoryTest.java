package co.za.mpholo.assessment.casinoservice.repository;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.domain.Transaction;
import co.za.mpholo.assessment.casinoservice.domain.TransactionType;
import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@DataJpaTest
class PlayerRepositoryTest {

    public static final BigDecimal BALANCE = new BigDecimal(1000);

    @Autowired
    PlayerRepository playerRepository;
    List<Transaction> transactionList = new ArrayList<>();
    PlayerDTO playerDTO;
    Player player;

    @BeforeEach
    void setUp() {
        for (int i = 1; i <=10 ; i++) {
            double amount = (Math.random()*1000)+10;
            Random r = new Random();
            final int randomTransactionType = r.nextInt(2);
            TransactionType type;
            if(randomTransactionType==0) {
                type=TransactionType.DEPOSIT;
            } else {
                type = TransactionType.DEDUCT;
            }

            Transaction transaction = new Transaction();
            transaction.setTransactionId(Long.valueOf(i));
            transaction.setType(type);
            transaction.setCreationDate(new Date());
            transaction.setAmount(new BigDecimal(amount));
            transactionList.add(transaction);
        }
        player = Player.builder()
                .transactions(transactionList)
                .balance(new BigDecimal(100))
                .playerId(1L)
                .build();

        playerDTO = PlayerDTO.builder()
                .transactions(transactionList)
                .balance(new BigDecimal(100))
                .playerId(1L)
                .build();
    }

    @Test
    void save() {
      //given - precondition or setup
        Player player = new Player();
        player.setPlayerId(1L);
        player.setBalance(BALANCE);


      //when - action or behaviour that we are going to test
        final Player save = playerRepository.save(player);

        //then - verify the output
        assertThat(player).isNotNull();
        assertThat(player.getBalance()).isEqualTo(BALANCE);

    }

    @Test
    void getPlayer() {
        //given - precondition or setup
        Player player = new Player();
        player.setPlayerId(1L);
        player.setBalance(BALANCE);
        final Player save = playerRepository.save(player);

        //when - action or behaviour that we are going to test
        final Optional<Player> foundEmployee = playerRepository.findById(player.getPlayerId());


        //then - verify the output
        assertThat(foundEmployee).isNotEmpty();
        assertThat(foundEmployee.get().getBalance()).isEqualTo(BALANCE);
    }
}