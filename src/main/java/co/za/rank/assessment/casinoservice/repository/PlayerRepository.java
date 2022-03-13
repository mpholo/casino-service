package co.za.rank.assessment.casinoservice.repository;

import co.za.rank.assessment.casinoservice.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
