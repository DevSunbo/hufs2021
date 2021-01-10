package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.StudyRoom;
import hufs2021.jeongbo.model.entity.StudyRoomPK;
import hufs2021.jeongbo.model.entity.StudyRoom;
import hufs2021.jeongbo.model.entity.StudyRoomPK;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.StudyRoomApiRequest;
import hufs2021.jeongbo.model.network.request.StudyRoomApiRequest;
import hufs2021.jeongbo.model.network.response.StudyRoomApiResponse;
import hufs2021.jeongbo.model.network.response.StudyRoomApiResponse;
import hufs2021.jeongbo.repository.StudyRoomRepository;
import hufs2021.jeongbo.repository.StudyRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studyroom") //localhost:8080/api/studyroom
public class StudyRoomController {

    @Autowired
    StudyRoomRepository studyRoomRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<StudyRoom> read(){
        List<StudyRoom> studyRoomLists = studyRoomRepository.findAll();
        // response(studyRoomLists);
        return studyRoomLists;
    }

    @GetMapping("")
    public Header<StudyRoomApiResponse> readId(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        StudyRoomPK studyRoomPK = new StudyRoomPK(id, number);
        return studyRoomRepository.findById(studyRoomPK)
                .map( item->response(item))
                .map(Header::OK)
                .orElseGet( () ->Header.ERROR("데이터 없음") );
    }

    @PostMapping("")
    @ResponseBody
    public Header<StudyRoomApiResponse> create(@RequestBody Header<StudyRoomApiRequest> request){

        StudyRoomApiRequest studyRoomApiRequest =request.getData();
        StudyRoom studyRoom = StudyRoom.builder()
                .rId(studyRoomApiRequest.getRId())
                .rNumber(studyRoomApiRequest.getRNumber())
                .rStatus(studyRoomApiRequest.getRStatus())
                .rDate(studyRoomApiRequest.getRDate())
                .rFrom(studyRoomApiRequest.getRFrom())
                .rEnd(studyRoomApiRequest.getREnd())
                .rMajor(studyRoomApiRequest.getRMajor())
                .rMax(studyRoomApiRequest.getRMax())
                .createdAt(LocalDateTime.now())
                .createdBy(studyRoomApiRequest.getCreatedBy())
                .updatedAt(studyRoomApiRequest.getUpdatedAt())
                .updatedBy(studyRoomApiRequest.getUpdatedBy())
                .build();

        //System.out.println(ai.getAiNumber());
        StudyRoom newAssetAllowedList = studyRoomRepository.save(studyRoom);
        return Header.OK(response(newAssetAllowedList));
    }

    @PutMapping("")
    public Header<StudyRoomApiResponse> update(@RequestBody Header<StudyRoomApiRequest> request){
        StudyRoomApiRequest studyRoomApiRequest = request.getData();
        StudyRoomPK studyRoomPK = new StudyRoomPK(studyRoomApiRequest.getRId(), studyRoomApiRequest.getRNumber());
        Optional<StudyRoom> optional = studyRoomRepository.findById(studyRoomPK);


        return optional.map(list -> {
            list
                    .setRId(studyRoomApiRequest.getRId())
                    .setRNumber(studyRoomApiRequest.getRNumber())
                    .setRStatus(studyRoomApiRequest.getRStatus())
                    .setRDate(studyRoomApiRequest.getRDate())
                    .setRFrom(studyRoomApiRequest.getRFrom())
                    .setREnd(studyRoomApiRequest.getREnd())
                    .setRMajor(studyRoomApiRequest.getRMajor())
                    .setRMax(studyRoomApiRequest.getRMax())
                    .setCreatedAt(studyRoomApiRequest.getCreatedAt())
                    .setUpdatedBy(studyRoomApiRequest.getUpdatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedAt(studyRoomApiRequest.getUpdatedAt());
            return list;
        })
                .map(list -> studyRoomRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @DeleteMapping("")
    public Header delete(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        StudyRoomPK studyRoomPK = new StudyRoomPK(id, number);
        System.out.println("Delete id : "+id);
        Optional<StudyRoom> optional = studyRoomRepository.findById(studyRoomPK);

        return optional.map( item ->{
            studyRoomRepository.delete(item);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    public StudyRoomApiResponse response(StudyRoom studyRoom){

        StudyRoomApiResponse assetAllowedListApiResponse = StudyRoomApiResponse.builder()
                .rId(studyRoom.getRId())
                .rNumber(studyRoom.getRNumber())
                .rStatus(studyRoom.getRStatus())
                .rDate(studyRoom.getRDate())
                .rFrom(studyRoom.getRFrom())
                .rEnd(studyRoom.getREnd())
                .rMajor(studyRoom.getRMajor())
                .rMax(studyRoom.getRMax())
                .createdAt(studyRoom.getCreatedAt())
                .createdBy(studyRoom.getCreatedBy())
                .updatedAt(studyRoom.getUpdatedAt())
                .updatedBy(studyRoom.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}
