package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.Major;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.MajorRequest;
import hufs2021.jeongbo.network.response.MajorResponse;
import hufs2021.jeongbo.repository.MajorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/major")
public class MajorController  {

    @Autowired
    private MajorRepository majorRepository;

    @PostMapping("/create")
    @ResponseBody
    public Header<MajorResponse> create(@RequestBody MajorRequest majorRequest) {

        Major major = Major.builder()
                .mName(majorRequest.getMName())
                .createdAt(LocalDateTime.now())
                .createdBy(majorRequest.getCreatedBy())
                .build();

       Major newMajor = majorRepository.save(major);

        if(newMajor!=null)
            return Header.OK(response(newMajor));
        else
            return Header.ERROR();
    }

    @GetMapping("/readall")
    @ResponseBody
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
    @ResponseBody
    public Header<MajorResponse> read(@RequestParam Integer id) {
        Optional<Major> majorOptional = majorRepository.findById(id);

        return majorOptional.map(major -> {
            System.out.println("전공 번호: " + major.getMCode());
            System.out.println("전공 명: " + major.getMName());
            System.out.println("등록일: " + major.getCreatedAt());
            System.out.println("등록자: " + major.getCreatedBy());
            return Header.OK(response(major));
        }).orElseGet(Header::ERROR);
    }

    @PutMapping("/update")
    @ResponseBody
    public Header<MajorResponse> update(@RequestBody MajorRequest majorRequest) {

        return majorRepository.findById(majorRequest.getMCode()).map(major -> {
            major.setMName(majorRequest.getMName());
            major.setUpdatedAt(LocalDateTime.now());
            major.setUpdatedBy(majorRequest.getUpdatedBy());

            Major updatedMajor = majorRepository.save(major);
            return Header.OK(response(updatedMajor));
        }).orElseGet(Header::ERROR);
    }

    @GetMapping("/delete")
    public Header<MajorResponse> delete(@RequestParam Integer id) {
        return majorRepository.findById(id).map(major -> {
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
