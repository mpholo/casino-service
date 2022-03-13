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

    TransactionDTO transact(Long playerId,Long transactionId, BigDecimal amount,
                            TransactionType transactionType);
    List<TransactionDTO> getTop10TransactionByPlayer(Long playerId);


}
