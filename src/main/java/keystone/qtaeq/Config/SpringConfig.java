package keystone.qtaeq.Config;

import keystone.qtaeq.repository.BoardRepository;
import keystone.qtaeq.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig{

    // 자바코드로 스프링 빈 설정
    // memberController -> memberService -> memberRepository

    // JPA;
    private final DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    // Board
    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }
    @Bean
    public BoardRepository boardRepository(){
        return new BoardRepository(em);
    }

}