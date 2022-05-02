package jpahook.jpashop.repository;

import jpahook.jpashop.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.smartcardio.Card;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
//    @PersistenceContext
//    private EntityManager em;

    List<Member> findByName(String name);


//
//    public Long save(Member member){
//        em.persist(member);
//        return member.getId();
//    }
//
//    public Member find(Long id){
//        return em.find(Member.class, id);
//    }
}
