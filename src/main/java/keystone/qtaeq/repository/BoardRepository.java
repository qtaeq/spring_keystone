package keystone.qtaeq.repository;

import keystone.qtaeq.domain.Entity.BoardEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BoardRepository {

    private final EntityManager em;

    public BoardRepository(EntityManager em){
        this.em = em;
    }

    public BoardEntity save(BoardEntity boardEntity){
        em.persist(boardEntity);
        return boardEntity;
    }

    public BoardEntity findById(Long id){
        BoardEntity boardEntity = em.find(BoardEntity.class, di);
        return boardEntity;
    }

    public List<BoardEntity> findAll(){
        List<BoardEntity> result = em.createQuery("select m from BoardEntity m", BoardEntity.class)
                .getResultList();
        
        // 여기서 날짜 가공해면 될듯
        
        return result;
    }
}
