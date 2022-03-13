package co.za.rank.assessment.casinoservice.controller;

import co.za.rank.assessment.casinoservice.domain.TransactionType;
import co.za.rank.assessment.casinoservice.model.TransactionDTO;
import co.za.rank.assessment.casinoservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/
@RestController
@RequestMapping("/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    final TransactionService transactionService;

    @GetMapping("/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getPlayerTransactions(@PathVariable Long playerId) {

        final List<TransactionDTO> playerTransactions = transactionService.getPlayerTransactions(playerId);
        return playerTransactions;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void transact(@RequestParam Long playerId,
                         @RequestParam BigDecimal amount,
                         @RequestParam TransactionType transactionType) {

        transactionService.transact(playerId,amount,transactionType);

    }
}
