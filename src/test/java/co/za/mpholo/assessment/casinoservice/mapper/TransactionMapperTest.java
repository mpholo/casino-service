package co.za.mpholo.assessment.casinoservice.mapper;

import co.za.mpholo.assessment.casinoservice.domain.Transaction;
import co.za.mpholo.assessment.casinoservice.domain.TransactionType;
import co.za.mpholo.assessment.casinoservice.model.TransactionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@SpringBootTest
class TransactionMapperTest {

    @Autowired
    TransactionMapper mapper;
    @Test
    void transactionToTransactionDTO() {
        //given - precondition or setup
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setAmount(new BigDecimal(1000));

        //when - action or behaviour that we are going to test
        final TransactionDTO transactionDTO = mapper.transactionToTransactionDTO(transaction);

        //then - verify the output
        assertThat(transactionDTO.getTransactionId()).isEqualTo(transaction.getTransactionId());
        assertThat(transactionDTO.getType()).isEqualTo(transaction.getType());
        assertThat(transactionDTO.getAmount()).isEqualTo(transaction.getAmount());
    }

    @Test
    void transactionDTOToTransaction() {
        //given - precondition or setup
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(1L);
        transactionDTO.setType(TransactionType.DEPOSIT);
        transactionDTO.setAmount(new BigDecimal(1000));

        //when - action or behaviour that we are going to test
        final Transaction transaction = mapper.transactionDTOToTransaction(transactionDTO);

        //then - verify the output
        assertThat(transaction.getTransactionId()).isEqualTo(transactionDTO.getTransactionId());
        assertThat(transaction.getType()).isEqualTo(transactionDTO.getType());
        assertThat(transaction.getAmount()).isEqualTo(transactionDTO.getAmount());
    }


}