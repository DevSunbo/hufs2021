package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.JeongboApplicationTests;
import hufs2021.jeongbo.model.entity.Major;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
class MajorRepositoryTest extends JeongboApplicationTests {

    @Autowired
    private MajorRepository majorRepository;

    @Test
    public void create(){

        Major major = Major.builder()
//                .mCode(7)
                .mName("정보통신공학과")
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

        Major newMajor = majorRepository.save(major);
        Assertions.assertNotNull(newMajor);
//        System.out.println(major.getMCode() + " " + major.getMName() + " " + major.getCreatedAt() + " " + major.getCreatedBy());
    }

    @Test
    public void readAll() {
        List<Major> majorList = majorRepository.findAll();

        if (majorList != null) {
            majorList.stream().forEach(major -> {
                System.out.println("전공 번호: " + major.getMCode());
                System.out.println("전공 명: " + major.getMName());
                System.out.println("등록일: " + major.getCreatedAt());
                System.out.println("등록자: " + major.getCreatedBy());
                System.out.println("--------------------------");
            });
        }

        Assertions.assertNotNull(majorList);
    }

    @Test
    public void read() {
        Optional<Major> majorOption = majorRepository.findById(3);

        majorOption.ifPresent(selectMajor -> {
            System.out.println("전공 번호: " + selectMajor.getMCode());
            System.out.println("전공 명: " + selectMajor.getMName());
            System.out.println("등록일: " + selectMajor.getCreatedAt());
            System.out.println("등록자: " + selectMajor.getCreatedBy());
        });
        Assertions.assertNotNull(majorOption);
    }

    @Test
    public void update() {
        Optional<Major> majorOptional = majorRepository.findById(3);

        majorOptional.ifPresent(selectMajor -> {
            selectMajor.setMName("AI학부");
            selectMajor.setCreatedAt(LocalDateTime.now());
            selectMajor.setCreatedBy(1234);

            Major newMajor = majorRepository.save(selectMajor);
            Assertions.assertNotNull(newMajor);
        });
        Assertions.assertNotNull(majorOptional);
    }

    @Test
    public void delete() {
        Optional<Major> majorOptional = majorRepository.findById(3);

        Assertions.assertTrue(majorOptional.isPresent());

        majorOptional.ifPresent(selectMajor -> {
            majorRepository.delete(selectMajor);
        });

        Optional<Major> deleteMajor = majorRepository.findById(3);

        Assertions.assertFalse(deleteMajor.isPresent());
    }

}