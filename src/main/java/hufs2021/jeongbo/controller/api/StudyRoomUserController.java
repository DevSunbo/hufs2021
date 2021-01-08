package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.StudyRoomUser;
import hufs2021.jeongbo.model.entity.StudyRoomUser;
import hufs2021.jeongbo.repository.AssetRepository;
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
    public List<StudyRoomUser> read(){
        return studyRoomUserRepository.findAll();
    }

    @GetMapping("")
    public Optional<StudyRoomUser> readId(@RequestParam(name = "id") Integer id){
        return studyRoomUserRepository.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody StudyRoomUser ru){

        StudyRoomUser studyRoomUser = StudyRoomUser.builder()
                .ruKey(ru.getRuKey())
                .ruId(ru.getRuId())
                .ruNumber(ru.getRuNumber())
                .ruStudentId(ru.getRuStudentId())
                .ruApplicant(ru.getRuApplicant())
                .createdAt(LocalDateTime.now())
                .createdBy(ru.getCreatedBy())
                .updatedAt(ru.getUpdatedAt())
                .updatedBy(ru.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        StudyRoomUser newStudyRoomUser = studyRoomUserRepository.save(studyRoomUser);
        return ;
    }

    @PutMapping("")
    public void update(@RequestBody StudyRoomUser ru){
        //Optional<StudyRoomUser> assetInventoryById = studyRoomUserRepository.findById(id); // 한 raw 데이터 받기

        StudyRoomUser studyRoomUser = StudyRoomUser.builder()
                .ruKey(ru.getRuKey())
                .ruId(ru.getRuId())
                .ruNumber(ru.getRuNumber())
                .ruStudentId(ru.getRuStudentId())
                .ruApplicant(ru.getRuApplicant())
                .createdAt(studyRoomUserRepository.findById(ru.getRuKey()).get().getCreatedAt())
                .createdBy(studyRoomUserRepository.findById(ru.getRuKey()).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(ru.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        StudyRoomUser newStudyRoomUser = studyRoomUserRepository.save(studyRoomUser);
        return ;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        studyRoomUserRepository.deleteById(id);
    }
}