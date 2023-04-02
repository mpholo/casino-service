package co.za.mpholo.assessment.casinoservice.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

class TransactionTest {

    @Test
    void testEquals() {
        //given - precondition or setup
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId(1L);
        transaction1.setType(TransactionType.DEPOSIT);
        transaction1.setAmount(new BigDecimal(1000));

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionId(1L);
        transaction2.setType(TransactionType.DEPOSIT);
        transaction2.setAmount(new BigDecimal(1000));

        //when - action or behaviour that we are going to test
         boolean isEqual = transaction1.equals(transaction2);
        //then - verify the output
        assertThat(transaction1).isEqualTo(transaction2);
    }


}