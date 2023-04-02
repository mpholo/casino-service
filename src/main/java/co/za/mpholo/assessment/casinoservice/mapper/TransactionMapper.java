package co.za.mpholo.assessment.casinoservice.mapper;

import co.za.mpholo.assessment.casinoservice.domain.Transaction;
import co.za.mpholo.assessment.casinoservice.model.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDTO transactionToTransactionDTO(Transaction transaction);
    Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);
}
