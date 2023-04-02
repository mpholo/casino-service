package co.za.mpholo.assessment.casinoservice.service;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.exception.PlayerExistsException;
import co.za.mpholo.assessment.casinoservice.mapper.PlayerMapper;
import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import co.za.mpholo.assessment.casinoservice.repository.PlayerRepository;
import co.za.mpholo.assessment.casinoservice.exception.PlayerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    @Override
    public Optional<PlayerDTO> getPlayerById(Long playerId) {

        final Optional<Player> player = playerRepository.findById(playerId);
        if(player.isEmpty()) {
            throw new PlayerNotFoundException("player id - "+playerId+" not found");
        }
        return Optional.of(mapper.PlayerToPlayerDTO(player.get()));
    }


    @Override
    public PlayerDTO updatePlayer(Long playerId, PlayerDTO playerDTO) {
        getPlayerById(playerId);
        final Player updatedPlayer = mapper.PlayerDTOToPlayer(playerDTO);
        final Player savedPlayer = save(updatedPlayer);
        final PlayerDTO updatedPlayerDTO = mapper.PlayerToPlayerDTO(savedPlayer);
        return updatedPlayerDTO;

    }

    @Override
    public PlayerDTO insertPlayer(PlayerDTO playerDTO) {
        final Optional<Player> playerByEmail = this.getPlayerByEmail(playerDTO.getEmail());
        if(playerByEmail.isEmpty()) {
            final Player player = mapper.PlayerDTOToPlayer(playerDTO);
            final Player newPlayer = this.save(player);
            return mapper.PlayerToPlayerDTO(newPlayer);
        }
        throw new PlayerExistsException("Player with email "+playerByEmail.get().getEmail() +" already exists");
    }

    private Player save(Player player) {
        final Player savedPlayer = playerRepository.save(player);
        return savedPlayer;
    }

    private Optional<Player> getPlayerByEmail(String email) {
        return playerRepository.findPlayerByEmail(email);
    }
}
