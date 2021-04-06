package keystone.qtaeq.service;

import keystone.qtaeq.domain.Member;
import keystone.qtaeq.repository.MemberRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional  // JPA
public class MemberService {

    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
    }


    // 회원가입
    public Long join(Member member){

        // 같은 이름이 있는 중복회원 색인
        validateDuplicateMember(member);
        memberRepo.save(member);
        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        memberRepo.findByName(member.getName()) // 결과가 Optional<Member> 형태
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){

        return memberRepo.findAll();
    }

    public Optional<Member> findOne(Long memberId){

        return memberRepo.findById(memberId);

    }
}
