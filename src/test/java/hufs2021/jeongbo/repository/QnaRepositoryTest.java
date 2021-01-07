package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.JeongboApplicationTests;
import hufs2021.jeongbo.model.entity.Qna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
class QnaRepositoryTest extends JeongboApplicationTests {

    @Autowired
    private QnaRepository qnaRepository;

    @Test
    public void create() {
        Qna qna = Qna.builder()
                .qaNumber(4)
                .qaDivision(1)
                .qaPrivate(0)
                .qaName("이건 진짜 몰라요")
                .qaField("기자재")
                .qaContent("기자재를 어떻게 신청해야되는지 도저히 모르겠어요")
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .student_id(201500909)
                .build();

        Qna newQna = qnaRepository.save(qna);

        Assertions.assertNotNull(newQna);
    }

    @Test
    public void readAll() {
        List<Qna> qnaList = qnaRepository.findAll();

        if (qnaList != null) {
            qnaList.stream().forEach(qna -> {
                System.out.println(qna.getQaNumber());
                System.out.println(qna.getQaDivision());
                System.out.println(qna.getQaPrivate());
                System.out.println(qna.getQaField());
                System.out.println(qna.getQaName());
                System.out.println(qna.getQaContent());
                System.out.println(qna.getCreatedAt());
                System.out.println(qna.getCreatedBy());
                System.out.println(qna.getStudent_id());
//                System.out.println(qna.getUser());
            });
        }

        Assertions.assertNotNull(qnaList);
    }

}