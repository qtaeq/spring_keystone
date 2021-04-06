package keystone.qtaeq;

import keystone.qtaeq.domain.Board;
import keystone.qtaeq.repository.BoardRepo;
import keystone.qtaeq.repository.JpaMember;
import keystone.qtaeq.repository.MemberRepo;
import keystone.qtaeq.service.BoardService;
import keystone.qtaeq.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

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

    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepo());
    }
    @Bean
    public BoardRepo boardRepo(){
        return new BoardRepo(em);
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());    // Else
    }

    @Bean
    public MemberRepo memberRepository(){

        return new JpaMember(em); //JPA
    }
}
