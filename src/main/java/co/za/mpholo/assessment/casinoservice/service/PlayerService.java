package co.za.mpholo.assessment.casinoservice.service;

import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;

import java.util.Optional;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

public interface PlayerService {

    Optional<PlayerDTO> getPlayerById(Long playerId);

    PlayerDTO updatePlayer(Long playerId, PlayerDTO playerDTO);

    PlayerDTO insertPlayer(PlayerDTO playerDTO);
}
