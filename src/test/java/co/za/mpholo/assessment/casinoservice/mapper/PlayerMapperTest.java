package co.za.mpholo.assessment.casinoservice.mapper;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@SpringBootTest
class PlayerMapperTest {


    @Autowired
    PlayerMapper mapper;
    @Test
    void playerToPlayerDTO() {
        //given - precondition or setup
        Player player = new Player();
        player.setPlayerId(1L);
        player.setBalance(new BigDecimal(1000));

        //when - action or behaviour that we are going to test
        final PlayerDTO playerDTO = mapper.PlayerToPlayerDTO(player);

        //then - verify the output
        assertThat(playerDTO.getPlayerId()).isEqualTo(player.getPlayerId());
        assertThat(playerDTO.getBalance()).isEqualTo(player.getBalance());

    }

    @Test
    void playerDTOToPlayer() {
        //given - precondition or setup
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerId(1L);
        playerDTO.setBalance(new BigDecimal(1000));

        //when - action or behaviour that we are going to test
        final Player player = mapper.PlayerDTOToPlayer(playerDTO);

        //then - verify the output
        assertThat(player.getPlayerId()).isEqualTo(playerDTO.getPlayerId());
        assertThat(player.getBalance()).isEqualTo(playerDTO.getBalance());
    }

}