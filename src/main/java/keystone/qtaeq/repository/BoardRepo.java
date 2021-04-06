package keystone.qtaeq.repository;

import keystone.qtaeq.domain.Board;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BoardRepo {

    private final EntityManager em;

    public BoardRepo(EntityManager em){
        this.em = em;
    }

    public Board save(Board board){
        em.persist(board);
        return board;
    }

    public Board findById(Long id){
        Board board = em.find(Board.class, id);
        return board;
    }

    public List<Board> findAll(){
        List<Board> result = em.createQuery("select m from Board m",Board.class)
                .getResultList();
        return result;
    }
}
