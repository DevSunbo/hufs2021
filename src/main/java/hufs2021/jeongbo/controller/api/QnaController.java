package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Qna;
import hufs2021.jeongbo.model.key.QnaId;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.QnaRequest;
import hufs2021.jeongbo.network.response.QnaResponse;
import hufs2021.jeongbo.repository.QnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/qna")
public class QnaController {

    @Autowired
    private QnaRepository qnaRepository;

    @PostMapping("/create")
    @ResponseBody
    public Header<QnaResponse> create(@RequestBody QnaRequest qnaRequest) {
        Qna qna = Qna.builder()
                .qaNumber(qnaRequest.getQaNumber())
                .qaDivision(qnaRequest.getQaDivision())
                .qaPrivate(qnaRequest.getQaPrivate())
                .qaField(qnaRequest.getQaField())
                .qaName(qnaRequest.getQaName())
                .qaContent(qnaRequest.getQaContent())
                .fId(qnaRequest.getFId())
                .createdAt(LocalDateTime.now())
                .createdBy(qnaRequest.getCreatedBy())
                .student_id(qnaRequest.getStudentId())
                .build();

        Qna newQna = qnaRepository.save(qna);

        if(newQna!=null)
            return Header.OK(response(qna));
        else
            return Header.ERROR();
    }

    @GetMapping("/readall")
    @ResponseBody
    public Header<QnaResponse> readAll() {
        List<Qna> qnaList = qnaRepository.findAll();

        if (qnaList != null) {
            qnaList.stream().forEach(qna -> {
                System.out.println(qna.getQaNumber());
                System.out.println(qna.getQaDivision());
                System.out.println(qna.getQaPrivate());
                System.out.println(qna.getQaName());
                System.out.println(qna.getQaField());
                System.out.println(qna.getQaContent());
                System.out.println(qna.getFId());
                System.out.println(qna.getCreatedAt());
                System.out.println(qna.getCreatedBy());
                System.out.println(qna.getUpdatedAt());
                System.out.println(qna.getUpdatedBy());
                System.out.println(qna.getStudent_id());
                System.out.println("----------------------------");
            });
            return Header.OK();
        }
        else
            return Header.ERROR();
    }

    @GetMapping("/read")
    @ResponseBody
    public Header<QnaResponse> read(@RequestParam Integer number, @RequestParam Integer division) {
        return qnaRepository.findById(new QnaId(number, division))
                .map(qna -> {
                    System.out.println(qna.getQaNumber());
                    System.out.println(qna.getQaDivision());
                    System.out.println(qna.getQaPrivate());
                    System.out.println(qna.getQaName());
                    System.out.println(qna.getQaField());
                    System.out.println(qna.getQaContent());
                    System.out.println(qna.getFId());
                    System.out.println(qna.getCreatedAt());
                    System.out.println(qna.getCreatedBy());
                    System.out.println(qna.getUpdatedAt());
                    System.out.println(qna.getUpdatedBy());
                    System.out.println(qna.getStudent_id());
                    return qna;
                }).map(qna -> Header.OK(response(qna)))
                .orElseGet(Header::ERROR);
    }

    @PutMapping("/update")
    @ResponseBody
    public Header<QnaResponse> update(@RequestBody QnaRequest qnaRequest) {

        return qnaRepository.findById(new QnaId(qnaRequest.getQaNumber(), qnaRequest.getQaDivision())).map(qna -> {
            qna.setQaPrivate(qnaRequest.getQaPrivate());
            qna.setQaName(qnaRequest.getQaName());
            qna.setQaField(qnaRequest.getQaField());
            qna.setQaContent(qnaRequest.getQaContent());
            qna.setFId(qnaRequest.getFId());
            qna.setUpdatedAt(LocalDateTime.now());
            qna.setUpdatedBy(qnaRequest.getUpdatedBy());
//            qna.setStudent_id(qnaRequest.getStudentId());
            return qna;
        }).map(qna -> qnaRepository.save(qna))
                .map(qna -> Header.OK(response(qna)))
                .orElseGet(Header::ERROR);
    }

    @DeleteMapping("/delete")
    public Header<QnaResponse> delete(@RequestParam Integer number, @RequestParam Integer division) {
        Optional<Qna> qnaOptional = qnaRepository.findById(new QnaId(number, division));

        qnaOptional.ifPresent(qna -> qnaRepository.delete(qna));

        Optional<Qna> deletedQna = qnaRepository.findById(new QnaId(number, division));

        if(deletedQna==null)
            return Header.OK();
        else
            return Header.ERROR();
    }

    private QnaResponse response(Qna qna) {
        return QnaResponse.builder()
                .qaNumber(qna.getQaNumber())
                .qaDivision(qna.getQaDivision())
                .qaPrivate(qna.getQaPrivate())
                .qaField(qna.getQaField())
                .qaName(qna.getQaName())
                .qaContent(qna.getQaContent())
                .fId(qna.getFId())
                .createdAt(qna.getCreatedAt())
                .createdBy(qna.getCreatedBy())
                .updatedAt(qna.getUpdatedAt())
                .updatedBy(qna.getUpdatedBy())
                .studentId(qna.getStudent_id())
                .build();

    }
}
