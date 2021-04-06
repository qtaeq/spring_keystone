package keystone.qtaeq.repository;

import keystone.qtaeq.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepo {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
