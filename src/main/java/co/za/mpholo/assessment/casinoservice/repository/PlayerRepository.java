package co.za.mpholo.assessment.casinoservice.repository;

import co.za.mpholo.assessment.casinoservice.domain.Player;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * Created by  : Mpholo Leboea on 2023/04/01
 **/

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Optional<Player> findPlayerByEmail(String email);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<Player> findById(Long aLong);
}
