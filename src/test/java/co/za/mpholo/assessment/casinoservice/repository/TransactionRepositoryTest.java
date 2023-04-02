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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

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
    void top10ByPlayerEqualsOrderByCreationDateDesc() {
      //given - precondition or setup
        playerRepository.save(player);

      //when - action or behaviour that we are going to test
        final List<Transaction> top10ByPlayerEqualsOrderByCreationDateDesc = transactionRepository.findTop10ByPlayerEqualsOrderByCreationDateDesc(player);

        //then - verify the output
        assertThat(transactionList).isNotNull();
        assertThat(transactionList.size()).isEqualTo(10);

    }
}