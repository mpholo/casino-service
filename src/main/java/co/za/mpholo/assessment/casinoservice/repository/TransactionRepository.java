package co.za.mpholo.assessment.casinoservice.repository;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import co.za.mpholo.assessment.casinoservice.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findTop10ByPlayerEqualsOrderByCreationDateDesc(Player player);
}
