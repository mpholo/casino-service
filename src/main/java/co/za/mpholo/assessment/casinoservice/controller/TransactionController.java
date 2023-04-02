package co.za.mpholo.assessment.casinoservice.controller;

import co.za.mpholo.assessment.casinoservice.domain.TransactionType;
import co.za.mpholo.assessment.casinoservice.model.TransactionDTO;
import co.za.mpholo.assessment.casinoservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@RestController
@RequestMapping("/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    final TransactionService transactionService;

    @GetMapping("/top10/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getPlayerTop10Transactions(@PathVariable Long playerId) {

        final List<TransactionDTO> playerTransactions = transactionService.getTop10TransactionByPlayer(playerId);
        return playerTransactions;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void transact(@RequestParam Long playerId,
                         @RequestParam Long transactionId,
                         @RequestParam BigDecimal amount,
                         @RequestParam TransactionType transactionType) {

        transactionService.transact(playerId,transactionId,amount,transactionType);

    }
}
