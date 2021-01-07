package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.StudyRoom;
import hufs2021.jeongbo.model.entity.StudyRoomPK;
import hufs2021.jeongbo.repository.StudyRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void create(@RequestBody StudyRoom sr){
        System.out.println("create");
        StudyRoom studyRoom = StudyRoom
    }

    @PutMapping("")
    public void updatePut(){
        System.out.println("updatePut");
    }

    @PatchMapping("")
    public void updatePatch(){
        System.out.println("updatePatch");
    }

    @DeleteMapping("")
    public void delete(){
        System.out.println("delete");
    }
}
