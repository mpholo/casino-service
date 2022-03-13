package co.za.rank.assessment.casinoservice.mapper;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.domain.Transaction;
import co.za.rank.assessment.casinoservice.model.PlayerDTO;
import co.za.rank.assessment.casinoservice.model.TransactionDTO;
import org.mapstruct.Mapper;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@Mapper
public interface TransactionMapper {

    TransactionDTO transactionToTransactionDTO(Transaction transaction);
    Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);
}
