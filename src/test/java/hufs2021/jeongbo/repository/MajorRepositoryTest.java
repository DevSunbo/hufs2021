package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.JeongboApplicationTests;
import hufs2021.jeongbo.model.entity.Major;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
class MajorRepositoryTest extends JeongboApplicationTests {

    @Autowired
    private MajorRepository majorRepository;

    @Test
    public void create(){

        Major major = Major.builder()
                .mCode(7)
                .mName("정보통신공학과")
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

        Major newMajor = majorRepository.save(major);
        Assertions.assertNotNull(newMajor);
//        System.out.println(major.getMCode() + " " + major.getMName() + " " + major.getCreatedAt() + " " + major.getCreatedBy());
    }
}