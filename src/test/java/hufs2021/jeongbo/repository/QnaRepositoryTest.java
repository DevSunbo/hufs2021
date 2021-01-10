package hufs2021.jeongbo.repository;

import hufs2021.jeongbo.JeongboApplicationTests;
import hufs2021.jeongbo.model.entity.Qna;
import hufs2021.jeongbo.model.enumclass.QnaField;
import hufs2021.jeongbo.model.key.QnaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
                .qaField(QnaField.ASSET)
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

    @Test
    public void read() {
        Optional<Qna> qnaOptional = qnaRepository.findById(new QnaId(2, 0));

        qnaOptional.ifPresent(selectQna -> {
            System.out.println(selectQna.getQaNumber());
            System.out.println(selectQna.getQaDivision());
            System.out.println(selectQna.getQaPrivate());
            System.out.println(selectQna.getQaField());
            System.out.println(selectQna.getQaName());
            System.out.println(selectQna.getQaContent());
            System.out.println(selectQna.getCreatedAt());
            System.out.println(selectQna.getCreatedBy());
            System.out.println(selectQna.getStudent_id());
        });
        Assertions.assertNotNull(qnaOptional);
    }

    @Test
    public void update() {
        Qna qna = Qna.builder()
                .qaNumber(2)
                .qaDivision(0)
                .qaPrivate(1)
                .qaName("팀플 질문이요")
                .qaField(QnaField.TEAM_PROJECT)
                .qaContent("팀플 신청 어떻게 해요")
                .updatedBy(4321)
                .build();

        Optional<Qna> qnaOptional = qnaRepository.findById(new QnaId(qna.getQaNumber(), qna.getQaDivision()));

        qnaOptional.ifPresent(selectQna -> {
            selectQna.setQaPrivate(qna.getQaPrivate());
            selectQna.setQaName(qna.getQaName());
            selectQna.setQaField(qna.getQaField());
            selectQna.setQaContent(qna.getQaContent());
            selectQna.setUpdatedAt(LocalDateTime.now());
            selectQna.setUpdatedBy(qna.getUpdatedBy());

            Qna updatedQna = qnaRepository.save(selectQna);
            Assertions.assertNotNull(updatedQna);
        });

        Assertions.assertNotNull(qnaOptional);
    }

    @Test
    public void delete() {
        Optional<Qna> qnaOptional = qnaRepository.findById(new QnaId(2, 0));

        Assertions.assertTrue(qnaOptional.isPresent());

        qnaOptional.ifPresent(selectQna -> {
            qnaRepository.delete(selectQna);
        });

        Optional<Qna> deletedQna = qnaRepository.findById(new QnaId(2, 0));

        Assertions.assertFalse(deletedQna.isPresent());

    }

}