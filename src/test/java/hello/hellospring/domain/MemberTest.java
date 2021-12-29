package hello.hellospring.domain;

import hello.hellospring.domain.Member.Member;
import hello.hellospring.domain.Member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberTest {

    @Autowired MemberRepository memberRepo;
    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021, 12, 29, 0, 0, 0);
        Member member = new Member();
        member.setId("member1");
        Long no = memberRepo.save(member);
        //when
        Member member1 = memberRepo.findOne(no);
        //then
        System.out.printf("createdDate=%s, modifiedDate=%s",member1.getCreatedDate(), member1.getModifiedDate());
        assertEquals(true, member1.getCreatedDate().isAfter(now));
        assertEquals(true, member1.getModifiedDate().isAfter(now));
    }
}