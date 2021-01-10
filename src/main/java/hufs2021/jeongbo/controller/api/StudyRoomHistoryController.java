package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.StudyRoomHistory;
import hufs2021.jeongbo.model.entity.StudyRoomHistory;
import hufs2021.jeongbo.model.entity.StudyRoomHistory;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.StudyRoomHistoryApiRequest;
import hufs2021.jeongbo.model.network.request.StudyRoomHistoryApiRequest;
import hufs2021.jeongbo.model.network.request.StudyRoomHistoryApiRequest;
import hufs2021.jeongbo.model.network.response.StudyRoomHistoryApiResponse;
import hufs2021.jeongbo.model.network.response.StudyRoomHistoryApiResponse;
import hufs2021.jeongbo.model.network.response.StudyRoomHistoryApiResponse;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.StudyRoomHistoryRepository;
import hufs2021.jeongbo.repository.StudyRoomHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studyroom/history") // localhost:8080/api/studyroom/history
public class StudyRoomHistoryController {

    @Autowired
    StudyRoomHistoryRepository studyRoomHistoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<StudyRoomHistory> read() {
        return  studyRoomHistoryRepository.findAll();
    }

    @GetMapping("")
    public Header<StudyRoomHistoryApiResponse> readId(@RequestParam(name = "id") Integer id) {
        return  studyRoomHistoryRepository.findById(id)
                .map(item -> response(item))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @PostMapping("")
    @ResponseBody
    public Header<StudyRoomHistoryApiResponse> create(@RequestBody Header<StudyRoomHistoryApiRequest> request) {
        StudyRoomHistoryApiRequest studyRoomHistoryApiRequest = request.getData();

        StudyRoomHistory studyRoomHistory = StudyRoomHistory.builder()
                .rhNumber(studyRoomHistoryApiRequest.getRhNumber())
                .rhDate(studyRoomHistoryApiRequest.getRhDate())
                .rhFrom(studyRoomHistoryApiRequest.getRhFrom())
                .rhEnd(studyRoomHistoryApiRequest.getRhEnd())
                .STUDYROOMRId(studyRoomHistoryApiRequest.getSTUDYROOMRId())
                .STUDYROOMRNumber(studyRoomHistoryApiRequest.getSTUDYROOMRNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(studyRoomHistoryApiRequest.getCreatedBy())
                .updatedAt(studyRoomHistoryApiRequest.getUpdatedAt())
                .updatedBy(studyRoomHistoryApiRequest.getUpdatedBy())
                .build();
        //System.out.println( studyRoomHistoryApiRequest.getAiNumber());
        StudyRoomHistory newAsset =  studyRoomHistoryRepository.save(studyRoomHistory);


        //System.out.println( studyRoomHistoryApiRequest.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<StudyRoomHistoryApiResponse> update(@RequestBody Header<StudyRoomHistoryApiRequest> request) {
        //Optional<StudyRoomHistory> assetInventoryById =  studyRoomHistoryRepository.findById(id); // 한 raw 데이터 받기
        StudyRoomHistoryApiRequest studyRoomHistoryApiRequest = request.getData();


        Optional<StudyRoomHistory> optional =  studyRoomHistoryRepository.findById(studyRoomHistoryApiRequest.getRhNumber());


        return optional.map(list -> {
            list
                    .setRhNumber(studyRoomHistoryApiRequest.getRhNumber())
                    .setRhDate(studyRoomHistoryApiRequest.getRhDate())
                    .setRhFrom(studyRoomHistoryApiRequest.getRhFrom())
                    .setRhEnd(studyRoomHistoryApiRequest.getRhEnd())
                    .setSTUDYROOMRId(studyRoomHistoryApiRequest.getSTUDYROOMRId())
                    .setSTUDYROOMRNumber(studyRoomHistoryApiRequest.getSTUDYROOMRNumber())
                    .setCreatedAt( studyRoomHistoryRepository.findById(studyRoomHistoryApiRequest.getRhNumber()).get().getCreatedAt())
                    .setCreatedBy( studyRoomHistoryRepository.findById(studyRoomHistoryApiRequest.getRhNumber()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(studyRoomHistoryApiRequest.getUpdatedBy());
            return list;
        })
                .map(list ->  studyRoomHistoryRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id) {
        System.out.println("Delete id : " + id);
        Optional<StudyRoomHistory> optional =  studyRoomHistoryRepository.findById(id);

        return optional.map(item -> {
            studyRoomHistoryRepository.delete(item);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    public StudyRoomHistoryApiResponse response(StudyRoomHistory studyRoomHistory) {

        StudyRoomHistoryApiResponse assetAllowedListApiResponse = StudyRoomHistoryApiResponse.builder()
                .rhNumber(studyRoomHistory.getRhNumber())
                .rhDate(studyRoomHistory.getRhDate())
                .rhFrom(studyRoomHistory.getRhFrom())
                .rhEnd(studyRoomHistory.getRhEnd())
                .STUDYROOMRId(studyRoomHistory.getSTUDYROOMRId())
                .STUDYROOMRNumber(studyRoomHistory.getSTUDYROOMRNumber())
                .createdAt(studyRoomHistory.getCreatedAt())
                .createdBy(studyRoomHistory.getCreatedBy())
                .updatedAt(studyRoomHistory.getUpdatedAt())
                .updatedBy(studyRoomHistory.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}