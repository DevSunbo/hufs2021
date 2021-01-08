package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.StudyRoomHistory;
import hufs2021.jeongbo.model.entity.StudyRoomHistory;
import hufs2021.jeongbo.repository.AssetRepository;
import hufs2021.jeongbo.repository.StudyRoomHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studyRoom/history") // localhost:8080/api/studyRoom/history
public class StudyRoomHistoryController {
    @Autowired
    StudyRoomHistoryRepository studyRoomHistoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<StudyRoomHistory> read(){
        return studyRoomHistoryRepository.findAll();
    }

    @GetMapping("")
    public Optional<StudyRoomHistory> readId(@RequestParam(name = "id") Integer id){
        return studyRoomHistoryRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody StudyRoomHistory rh){

        StudyRoomHistory studyRoomHistory = StudyRoomHistory.builder()
                .rhNumber(rh.getRhNumber())
                .rhDate(rh.getRhDate())
                .rhFrom(rh.getRhFrom())
                .rhEnd(rh.getRhEnd())
                .STUDYROOMRId(rh.getSTUDYROOMRId())
                .STUDYROOMRNumber(rh.getSTUDYROOMRNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(rh.getCreatedBy())
                .updatedAt(rh.getUpdatedAt())
                .updatedBy(rh.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        StudyRoomHistory newAssetInventory = studyRoomHistoryRepository.save(studyRoomHistory);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody StudyRoomHistory rh){
        //Optional<StudyRoomHistory> assetInventoryById = studyRoomHistoryRepository.findById(id); // 한 raw 데이터 받기

        StudyRoomHistory studyRoomHistory = StudyRoomHistory.builder()
                .rhNumber(rh.getRhNumber())
                .rhDate(rh.getRhDate())
                .rhFrom(rh.getRhFrom())
                .rhEnd(rh.getRhEnd())
                .STUDYROOMRId(rh.getSTUDYROOMRId())
                .STUDYROOMRNumber(rh.getSTUDYROOMRNumber())
                .createdAt(studyRoomHistoryRepository.findById(rh.getRhNumber()).get().getCreatedAt())
                .createdBy(studyRoomHistoryRepository.findById(rh.getRhNumber()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(rh.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        StudyRoomHistory newAssetInventory = studyRoomHistoryRepository.save(studyRoomHistory);
        return ;
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        studyRoomHistoryRepository.deleteById(id);
    }
}