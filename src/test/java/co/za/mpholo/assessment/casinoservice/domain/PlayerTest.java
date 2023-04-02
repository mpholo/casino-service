package co.za.mpholo.assessment.casinoservice.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

class PlayerTest {

    @Test
    void testEquals() {
        //given - precondition or setup
        Player player1 = new Player();
        player1.setPlayerId(1L);
        player1.setBalance(new BigDecimal(1000));

        Player player2 = new Player();
        player2.setPlayerId(1L);
        player2.setBalance(new BigDecimal(2000));


        //when - action or behaviour that we are going to test
        boolean isEqual = player1.equals(player2);

        //then - verify the output
        assertThat(player1).isEqualTo(player2);
    }


}