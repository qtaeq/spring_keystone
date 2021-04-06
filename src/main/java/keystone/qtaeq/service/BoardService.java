package keystone.qtaeq.service;

import keystone.qtaeq.domain.Board;
import keystone.qtaeq.repository.BoardRepo;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BoardService {
    private final BoardRepo boardRepo;

    public BoardService(BoardRepo boardRepo){
        this.boardRepo = boardRepo;
    }

    public Long create(Board board){
        boardRepo.save(board);
        return board.get_id();
    }

    public Board viewDetail(Long id){
        return boardRepo.findById(id);
    }

    public List<Board> allList(){
        return boardRepo.findAll();
    }
}
