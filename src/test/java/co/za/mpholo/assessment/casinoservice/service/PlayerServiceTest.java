package co.za.mpholo.assessment.casinoservice.service;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.exception.PlayerExistsException;
import co.za.mpholo.assessment.casinoservice.mapper.PlayerMapper;
import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import co.za.mpholo.assessment.casinoservice.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    PlayerRepository playerRepository;

    @Mock
    PlayerMapper playerMapper;

   @InjectMocks
    PlayerServiceImpl playerService;

    PlayerDTO playerDTO;
    Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
        player.setPlayerId(1L);
        player.setFirstName("James");
        player.setLastName("Fing");
        player.setEmail("james.fing@gmail.com");
        player.setBalance(new BigDecimal(1000));

        playerDTO = new PlayerDTO();
        playerDTO.setPlayerId(1L);
        playerDTO.setFirstName("Thabisu");
        playerDTO.setLastName("Sefatsa");
        playerDTO.setEmail("thabiso.sefatsa@gmail.com");
        playerDTO.setBalance(new BigDecimal(1000));
    }

    @Test
    void getPlayer() {
        //given - precondition or setup
        given(playerRepository.findById(player.getPlayerId())).willReturn(Optional.of(player));
        given(playerMapper.PlayerToPlayerDTO(player)).willReturn(playerDTO);

        //when - action or behaviour that we are going to test
        final Optional<PlayerDTO> foundPlayer = playerService.getPlayerById(player.getPlayerId());

        //then - verify the output
        assertThat(foundPlayer).isNotEmpty();
        assertThat(foundPlayer.get().getBalance()).isEqualTo(new BigDecimal(1000));

    }

    @Test
    void insertPlayer() {
        //given - precondition or setup
        given(playerRepository.findPlayerByEmail(anyString())).willReturn(Optional.empty());
        given(playerMapper.PlayerToPlayerDTO(player)).willReturn(playerDTO);
        given(playerMapper.PlayerDTOToPlayer(playerDTO)).willReturn(player);
        given(playerRepository.save(player)).willReturn(player);

        //when - action or behaviour that we are going to test
        final PlayerDTO save = playerService.insertPlayer(playerDTO);

        //then - verify the output
        assertThat(save).isNotNull();
    }

    @Test
    void insertPlayerThrowsException() {
        //given - precondition or setup
        given(playerRepository.findPlayerByEmail(anyString())).willReturn(Optional.of(player));


        //when - action or behaviour that we are going to test
        assertThrows(PlayerExistsException.class,()->{
            final PlayerDTO save = playerService.insertPlayer(playerDTO);
        });

        //then - verify the output
        verify(playerRepository,never()).save(player);
    }

    @Test
    void updatePlayer() {
        //given - precondition or setup
        playerDTO.setFirstName("Thabiso");
        given(playerRepository.findById(player.getPlayerId())).willReturn(Optional.of(player));
        given(playerMapper.PlayerToPlayerDTO(player)).willReturn(playerDTO);
        given(playerMapper.PlayerDTOToPlayer(playerDTO)).willReturn(player);
        given(playerRepository.save(player)).willReturn(player);

        //when - action or behaviour that we are going to test
        final PlayerDTO updatedPlayerDTO = playerService.updatePlayer(1L, playerDTO);

        //then - verify the output
        assertThat(updatedPlayerDTO).isNotNull();
        assertThat(playerDTO.getPlayerId()).isEqualTo(updatedPlayerDTO.getPlayerId());
        assertThat(updatedPlayerDTO.getFirstName()).isEqualTo("Thabiso");
    }
}