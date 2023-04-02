package co.za.mpholo.assessment.casinoservice.service;

import co.za.mpholo.assessment.casinoservice.domain.TransactionType;
import co.za.mpholo.assessment.casinoservice.model.TransactionDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/



public interface TransactionService {

    TransactionDTO transact(Long playerId, Long transactionId, BigDecimal amount,
                            TransactionType transactionType);
    List<TransactionDTO> getTop10TransactionByPlayer(Long playerId);


}
