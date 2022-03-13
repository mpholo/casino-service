package co.za.rank.assessment.casinoservice.service;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.mapper.PlayerMapper;
import co.za.rank.assessment.casinoservice.model.PlayerDTO;
import co.za.rank.assessment.casinoservice.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    @Override
    public Optional<PlayerDTO> getPlayer(Long playerId) {

        final Optional<Player> player = playerRepository.findById(playerId);
        if(!player.isPresent()) {
            throw new PlayerNotFoundException("player id - "+playerId+" not found");
        }
        return Optional.of(mapper.PlayerToPlayerDTO(player.get()));
    }

    @Override
    public PlayerDTO save(PlayerDTO playerDTO) {
        final Player savedPlayer = playerRepository.save(mapper.PlayerDTOToPlayer(playerDTO));
        return mapper.PlayerToPlayerDTO(savedPlayer);
    }
}
