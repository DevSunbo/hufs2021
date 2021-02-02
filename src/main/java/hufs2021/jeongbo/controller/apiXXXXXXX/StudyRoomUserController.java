package hufs2021.jeongbo.controller.apiXXXXXXX;

import hufs2021.jeongbo.model.entity.StudyRoomUser;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.StudyRoomUserApiRequest;
import hufs2021.jeongbo.model.network.response.StudyRoomUserApiResponse;
import hufs2021.jeongbo.repository.StudyRoomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/studyroom/user") // localhost:8080/api/studyroom/user
public class StudyRoomUserController {
    @Autowired
    StudyRoomUserRepository studyRoomUserRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<StudyRoomUser> read() {
        return  studyRoomUserRepository.findAll();
    }

    @GetMapping("")
    public Header<StudyRoomUserApiResponse> readId(@RequestParam(name = "id") Integer id) {
        return  studyRoomUserRepository.findById(id)
                .map(item -> response(item))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @PostMapping("")
    @ResponseBody
    public Header<StudyRoomUserApiResponse> create(@RequestBody Header<StudyRoomUserApiRequest> request) {
        StudyRoomUserApiRequest studyRoomUserApiRequest = request.getData();

        StudyRoomUser studyRoomUser = StudyRoomUser.builder()
                .ruKey(studyRoomUserApiRequest.getRuKey())
                .ruId(studyRoomUserApiRequest.getRuId())
                .ruNumber(studyRoomUserApiRequest.getRuNumber())
                .ruStudentId(studyRoomUserApiRequest.getRuStudentId())
                .ruApplicant(studyRoomUserApiRequest.getRuApplicant())
                .createdAt(LocalDateTime.now())
                .createdBy(studyRoomUserApiRequest.getCreatedBy())
                .updatedAt(studyRoomUserApiRequest.getUpdatedAt())
                .updatedBy(studyRoomUserApiRequest.getUpdatedBy())
                .build();
        //System.out.println( studyRoomUserApiRequest.getAiNumber());
        StudyRoomUser newAsset =  studyRoomUserRepository.save(studyRoomUser);


        //System.out.println( studyRoomUserApiRequest.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<StudyRoomUserApiResponse> update(@RequestBody Header<StudyRoomUserApiRequest> request) {
        //Optional<StudyRoomUser> assetInventoryById =  studyRoomUserRepository.findById(id); // 한 raw 데이터 받기
        StudyRoomUserApiRequest studyRoomUserApiRequest = request.getData();


        Optional<StudyRoomUser> optional =  studyRoomUserRepository.findById(studyRoomUserApiRequest.getRuKey());


        return optional.map(list -> {
            list
                    .setRuKey(studyRoomUserApiRequest.getRuKey())
                    .setRuId(studyRoomUserApiRequest.getRuId())
                    .setRuNumber(studyRoomUserApiRequest.getRuNumber())
                    .setRuStudentId(studyRoomUserApiRequest.getRuStudentId())
                    .setRuApplicant(studyRoomUserApiRequest.getRuApplicant())
                    .setCreatedAt( studyRoomUserRepository.findById(studyRoomUserApiRequest.getRuKey()).get().getCreatedAt())
                    .setCreatedBy( studyRoomUserRepository.findById(studyRoomUserApiRequest.getRuKey()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(studyRoomUserApiRequest.getUpdatedBy());
            return list;
        })
                .map(list ->  studyRoomUserRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id) {
        System.out.println("Delete id : " + id);
        Optional<StudyRoomUser> optional =  studyRoomUserRepository.findById(id);

        return optional.map(item -> {
            studyRoomUserRepository.delete(item);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public StudyRoomUserApiResponse response(StudyRoomUser studyRoomUser) {

        StudyRoomUserApiResponse assetAllowedListApiResponse = StudyRoomUserApiResponse.builder()
                .ruKey(studyRoomUser.getRuKey())
                .ruId(studyRoomUser.getRuId())
                .ruNumber(studyRoomUser.getRuNumber())
                .ruStudentId(studyRoomUser.getRuStudentId())
                .ruApplicant(studyRoomUser.getRuApplicant())
                .createdAt(studyRoomUser.getCreatedAt())
                .createdBy(studyRoomUser.getCreatedBy())
                .updatedAt(studyRoomUser.getUpdatedAt())
                .updatedBy(studyRoomUser.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}