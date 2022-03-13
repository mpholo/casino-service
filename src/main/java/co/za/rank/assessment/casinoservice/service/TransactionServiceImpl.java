package co.za.rank.assessment.casinoservice.service;

import co.za.rank.assessment.casinoservice.domain.Player;
import co.za.rank.assessment.casinoservice.domain.Transaction;
import co.za.rank.assessment.casinoservice.domain.TransactionType;
import co.za.rank.assessment.casinoservice.mapper.PlayerMapper;
import co.za.rank.assessment.casinoservice.mapper.TransactionMapper;
import co.za.rank.assessment.casinoservice.model.PlayerDTO;
import co.za.rank.assessment.casinoservice.model.TransactionDTO;
import co.za.rank.assessment.casinoservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/12
 **/

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    final TransactionRepository transactionRepository;
    final PlayerService playerService;
    final TransactionMapper transactionMapper;
    final PlayerMapper playerMapper;


    @Override
    public List<TransactionDTO> getTop10TransactionByPlayer(Long playerId) {
        final Optional<PlayerDTO> playerDTO = playerService.getPlayer(playerId);
        Player player = playerMapper.PlayerDTOToPlayer(playerDTO.get());

        final List<Transaction> transactions = transactionRepository
                .findTop10ByPlayerEqualsOrderByCreationDateDesc(player);

        final List<TransactionDTO> transactionList = transactions.stream()
                .map(transactionMapper::transactionToTransactionDTO)
                .collect(Collectors.toList());

        return transactionList;
    }

    @Transactional
    @Override
    public TransactionDTO transact(Long playerId,Long transactionId, BigDecimal amount,
                                   TransactionType transactionType) {

        final Optional<PlayerDTO> player = playerService.getPlayer(playerId);
        final Optional<Transaction> searchedTransaction = transactionRepository.findById(transactionId);

        if(!searchedTransaction.isEmpty()) {
            throw new RuntimeException("Transaction already exists");
        } else if( transactionType.equals(TransactionType.DEDUCT) && player.get().getBalance().compareTo(amount)<0) {
            throw new RuntimeException("teapot(418)");
        }

        final PlayerDTO playerDTO = player.get();
        final TransactionDTO newTran = new TransactionDTO();
        BigDecimal result = new BigDecimal(0);
        newTran.setTransactionId(transactionId);
        newTran.setAmount(amount);
        switch (transactionType) {
            case DEDUCT:
                log.info("Deducting {} amount from player {}", amount, playerDTO.getPlayerId());
                newTran.setType(TransactionType.DEDUCT);
                result = playerDTO.getBalance().subtract(amount);
                break;
            case DEPOSIT:
                log.info("Depositing {} amount for player {}", amount, playerDTO.getPlayerId());
                newTran.setType(TransactionType.DEPOSIT);
                result = playerDTO.getBalance().add(amount);
                break;
            default:
                assert false : "Invalid transaction";
        }
        playerDTO.setBalance(result);
        playerService.save(playerDTO);
        newTran.setPlayer(playerMapper.PlayerDTOToPlayer(playerDTO));
        final Transaction savedTransaction = transactionRepository
                .save(transactionMapper.transactionDTOToTransaction(newTran));
        return transactionMapper.transactionToTransactionDTO(savedTransaction);

    }
}
