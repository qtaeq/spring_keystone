package keystone.qtaeq.service;

import keystone.qtaeq.domain.Member;
import keystone.qtaeq.repository.MemberRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional   // 테스트 이전 백업후 테스트 후 데이터베이스 롤백
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberService members;

    @Autowired
    MemberRepo memberRepository;

    @Test
    public void 전체회원조회() throws Exception {

        List<Member> allMember = memberService.findMembers();
    }

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hellow");
        //When
        Long saveId = memberService.join(member);
        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring2");
        Member member2 = new Member();
        member2.setName("spring3");
        //When

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
