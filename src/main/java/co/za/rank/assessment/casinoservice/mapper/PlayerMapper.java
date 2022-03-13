package co.za.rank.assessment.casinoservice.mapper;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.model.PlayerDTO;
import org.mapstruct.Mapper;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@Mapper
public interface PlayerMapper {

    PlayerDTO PlayerToPlayerDTO(Player player);
    Player PlayerDTOToPlayer(PlayerDTO playerDTO);
}
