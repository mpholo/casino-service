package co.za.rank.assessment.casinoservice.service;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.model.PlayerDTO;

import java.util.Optional;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

public interface PlayerService {

    Optional<PlayerDTO> getPlayer(Long playerId);
    PlayerDTO save(PlayerDTO playerDTO);

}
