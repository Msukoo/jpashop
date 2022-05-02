package jpahook.jpashop.service;

import jpahook.jpashop.domain.entity.Member;
import jpahook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        // EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Transactional(readOnly = true) // (readOnly = true) : jpa 조회시 성능 최적화. 읽기에는 가급적 넣는게 좋음
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findById(memberId).get();

    }
}
