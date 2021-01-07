package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.StudyRoom;
import hufs2021.jeongbo.model.entity.StudyRoomPK;
import hufs2021.jeongbo.repository.StudyRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studyRoom") //localhost:8080/api/studyRoom
public class StudyRoomController {
    @Autowired
    StudyRoomRepository studyRoomRepository;

    @GetMapping("/all")
    public List<StudyRoom> readAll(){
        return studyRoomRepository.findAll();
    }

    @GetMapping("")
    public Optional<StudyRoom> read(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        StudyRoomPK studyRoomPK = new StudyRoomPK(id, number);
        return studyRoomRepository.findById(studyRoomPK);
    }

    @PostMapping("")
    @ResponseBody
    public void create(@RequestBody StudyRoom sr){
        System.out.println("create");
        StudyRoom studyRoomC = StudyRoom.builder()
                .rId(sr.getRId())
                .rNumber(sr.getRNumber())
                .rStatus(sr.getRStatus())
                .rDate(sr.getRDate())
                .rFrom(sr.getRFrom())
                .rEnd(sr.getREnd())
                .rMajor(sr.getRMajor())
                .rMax(sr.getRMax())
                .createdAt(LocalDateTime.now())
                .createdBy(sr.getCreatedBy())
                .updatedAt(sr.getUpdatedAt())
                .updatedBy(sr.getUpdatedBy())
                .build();

        StudyRoom newStudyRoom = studyRoomRepository.save(studyRoomC);

    }

   @PutMapping("") // 전체 수정
    public void updatePut(@RequestBody StudyRoom sr){
        System.out.println("updatePut");
        StudyRoomPK studyRoomPK = new StudyRoomPK(sr.getRId(), sr.getRNumber());
        StudyRoom studyRoomUPt = StudyRoom.builder()
                .rId(sr.getRId())
                .rNumber(sr.getRNumber())
                .rStatus(sr.getRStatus())
                .rDate(sr.getRDate())
                .rFrom(sr.getRFrom())
                .rEnd(sr.getREnd())
                .rMajor(sr.getRMajor())
                .rMax(sr.getRMax())
                .createdAt(studyRoomRepository.findById(studyRoomPK).get().getCreatedAt())
                .createdBy(studyRoomRepository.findById(studyRoomPK).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(sr.getUpdatedBy())
                .build();

        StudyRoom newStudyRoom = studyRoomRepository.save(studyRoomUPt);
    }

    @PatchMapping("") // 일부 수정
    public void updatePatch(@RequestBody StudyRoom sr){
        System.out.println("updatePatch");
        StudyRoomPK studyRoomPK = new StudyRoomPK(sr.getRId(), sr.getRNumber());
        StudyRoom studyRoomUPh = StudyRoom.builder()
                .rId(sr.getRId())
                .rNumber(sr.getRNumber())
                .rStatus(sr.getRStatus())
                .createdAt(studyRoomRepository.findById(studyRoomPK).get().getCreatedAt())
                .createdBy(studyRoomRepository.findById(studyRoomPK).get().getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(sr.getUpdatedBy())
                .build();

        StudyRoom newStudyRoom = studyRoomRepository.save(studyRoomUPh);
    }

    @DeleteMapping("")
    public void delete(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        System.out.println("delete");
        StudyRoomPK studyRoomPK = new StudyRoomPK(id, number);
         studyRoomRepository.deleteById(studyRoomPK);
    }
}
