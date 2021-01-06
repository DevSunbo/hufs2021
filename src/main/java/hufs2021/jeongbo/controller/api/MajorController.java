package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Major;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.response.MajorResponse;
import hufs2021.jeongbo.repository.MajorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/major")
public class MajorController  {

    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("/create")
    public Header<MajorResponse> create() {

        Major major = Major.builder()
//                .mCode(majorRequest.getMCode())
                .mName("컴퓨터 공학부")
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

       Major newMajor = majorRepository.save(major);

        if(newMajor!=null)
            return Header.OK(response(newMajor));
        else
            return Header.ERROR();

    }

    @GetMapping("/readall")
    public Header<MajorResponse> readAll() {
       List<Major> majorList = majorRepository.findAll();

        if(majorList!=null){
            majorList.stream().forEach(major -> {
                System.out.println("전공 번호: " + major.getMCode());
                System.out.println("전공 명: " + major.getMName());
                System.out.println("등록일: " + major.getCreatedAt());
                System.out.println("등록자: " + major.getCreatedBy());
                System.out.println("--------------------------");
            });
            return Header.OK();
        }
        else
            return Header.ERROR();

    }

    @GetMapping("/read")
    public Header<MajorResponse> read() {
        Optional<Major> majorOptional = majorRepository.findById(3);

        return majorOptional.map(major -> {
            System.out.println("전공 번호: " + major.getMCode());
            System.out.println("전공 명: " + major.getMName());
            System.out.println("등록일: " + major.getCreatedAt());
            System.out.println("등록자: " + major.getCreatedBy());
            return Header.OK(response(major));
        }).orElseGet(Header::ERROR);
    }

    @GetMapping("/update")
    public Header<MajorResponse> update() {
        Major newMajor = Major.builder()
                .mName("전자정보공학과")
                .updatedAt(LocalDateTime.now())
                .updatedBy(1234)
                .build();

        return majorRepository.findById(3).map(major -> {
            major.setMName(newMajor.getMName());
            major.setUpdatedAt(newMajor.getUpdatedAt());
            major.setUpdatedBy(newMajor.getUpdatedBy());

            Major updatedMajor = majorRepository.save(major);
            return Header.OK(response(updatedMajor));
        }).orElseGet(Header::ERROR);
    }

    @GetMapping("/delete")
    public Header<MajorResponse> delete() {
        return majorRepository.findById(3).map(major -> {
            majorRepository.delete(major);
            return Header.OK(response(major));
        }).orElseGet(Header::ERROR);
    }

    private MajorResponse response(Major major) {
        return MajorResponse.builder()
                .mCode(major.getMCode())
                .mName(major.getMName())
                .createdAt(major.getCreatedAt())
                .createdBy(major.getCreatedBy())
                .build();
    }

}
