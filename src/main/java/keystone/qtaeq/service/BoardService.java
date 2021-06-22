package keystone.qtaeq.service;

import keystone.qtaeq.domain.Entity.BoardEntity;
import keystone.qtaeq.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public Long create(BoardEntity boardEntity){
        boardRepository.save(boardEntity);
        return boardEntity.get_id();
    }



    public BoardEntity viewDetail(Long id){
        return boardRepository.findById(id);
    }

    public List<BoardEntity> allList(){
        return boardRepository.findAll();
    }
}
