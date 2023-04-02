package co.za.mpholo.assessment.casinoservice.controller;

import co.za.mpholo.assessment.casinoservice.model.PlayerDTO;
import co.za.mpholo.assessment.casinoservice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/


@RestController
@RequestMapping("/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    final PlayerService playerService;

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable Long playerId) {
        final Optional<PlayerDTO> player = playerService.getPlayerById(playerId);
        return ResponseEntity.ok(player.get());

    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long playerId,@Valid @RequestBody PlayerDTO playerDTO) {
        final PlayerDTO player = playerService.updatePlayer(playerId,playerDTO);
        return new ResponseEntity<>(player,HttpStatus.OK);

    }

    @PostMapping

    public ResponseEntity<PlayerDTO> insertPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        final PlayerDTO player = playerService.insertPlayer(playerDTO);
        return new ResponseEntity<PlayerDTO>(player,HttpStatus.CREATED);
    }




}
