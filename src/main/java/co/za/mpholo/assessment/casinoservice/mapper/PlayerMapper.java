package co.za.mpholo.assessment.casinoservice.mapper;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    PlayerDTO PlayerToPlayerDTO(Player player);
    Player PlayerDTOToPlayer(PlayerDTO playerDTO);
}
