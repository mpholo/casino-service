package co.za.rank.assessment.casinoservice.service;

import co.za.rank.assessment.casinoservice.domain.TransactionType;
import co.za.rank.assessment.casinoservice.model.TransactionDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/


public interface TransactionService {

    List<TransactionDTO> getPlayerTransactions(Long playerId);
    TransactionDTO transact(Long playerId,BigDecimal amount, TransactionType transactionType);

}
