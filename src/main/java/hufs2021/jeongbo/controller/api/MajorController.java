package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Major;
import hufs2021.jeongbo.repository.MajorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/major")
public class MajorController{

    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("")
    public String test() {
        return "하이헬로우";
    }

    @GetMapping("/create")
    public String create() {
        Major major = Major.builder()
                .mName("통계학과")
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

        Major newMajor = majorRepository.save(major);

        if(newMajor!=null)
            return "성공";
        else
            return "실패";
    }

    @GetMapping("/read")
    public List<Major> read() {
        List<Major> majorList = majorRepository.findAll();

        if (majorList != null) {
            return majorList;
        } else return null;
    }
}
