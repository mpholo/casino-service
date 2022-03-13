package co.za.rank.assessment.casinoservice.controller;

import co.za.rank.assessment.casinoservice.model.PlayerDTO;
import co.za.rank.assessment.casinoservice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@RestController
@RequestMapping("/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    final PlayerService playerService;

    @GetMapping("/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDTO getPlayer(@PathVariable Long playerId) {
        final Optional<PlayerDTO> player = playerService.getPlayer(playerId);
        return player.get();

    }


}
