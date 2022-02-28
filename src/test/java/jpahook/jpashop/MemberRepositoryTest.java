package jpahook.jpashop;

import jpahook.jpashop.entity.Member;
import jpahook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // entityManager로 변경되는 경우에는 항상 transactional처리 필요
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("minsu");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(findMember.getUsername());

    }

}
