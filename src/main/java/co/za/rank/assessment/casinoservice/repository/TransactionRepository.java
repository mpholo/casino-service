package co.za.rank.assessment.casinoservice.repository;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findByPlayer(Player player);
}
