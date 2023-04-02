package co.za.mpholo.assessment.casinoservice.service;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.domain.Transaction;
import co.za.mpholo.assessment.casinoservice.domain.TransactionType;
import co.za.mpholo.assessment.casinoservice.mapper.PlayerMapper;
import co.za.mpholo.assessment.casinoservice.mapper.TransactionMapper;
import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import co.za.mpholo.assessment.casinoservice.model.TransactionDTO;
import co.za.mpholo.assessment.casinoservice.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    TransactionMapper transactionMapper;
    @Mock
    PlayerMapper playerMapper;

    @Mock
    PlayerServiceImpl playerService;

    @InjectMocks
    TransactionServiceImpl transactionService;





    List<Transaction> transactionList = new ArrayList<>();
    Player player;
    PlayerDTO playerDTO;

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
    void getTop10TransactionByPlayer() {

        //given - precondition or setup
        given(playerService.getPlayerById(anyLong())).willReturn(Optional.of(playerDTO));
        given(playerMapper.PlayerDTOToPlayer(any(PlayerDTO.class))).willReturn(player);
        given(transactionRepository.findTop10ByPlayerEqualsOrderByCreationDateDesc(player)).willReturn(transactionList);


        //when - action or behaviour that we are going to test
        final List<TransactionDTO> top10TransactionByPlayer = transactionService.getTop10TransactionByPlayer(player.getPlayerId());

        //then - verify the output
        assertThat(top10TransactionByPlayer).isNotNull();
        assertThat(top10TransactionByPlayer.size()).isEqualTo(10);
    }


    @Test
    void transact() {
        //given - precondition or setup

        //when - action or behaviour that we are going to test

        //then - verify the output
    }

}