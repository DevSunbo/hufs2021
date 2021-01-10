package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetAllowedList;
import hufs2021.jeongbo.model.entity.AssetAllowedListPK;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.AssetAllowedListApiRequest;
import hufs2021.jeongbo.model.network.response.AssetAllowedListApiResponse;
import hufs2021.jeongbo.repository.AssetAllowedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/asset/allowedlist") // localhost:8080/api/asset/allowedlist
public class AssetAllowedListController {
    @Autowired
    AssetAllowedListRepository assetAllowedListRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetAllowedList> read(){
        List<AssetAllowedList> assetAllowedLists = assetAllowedListRepository.findAll();
               // response(assetAllowedLists);
        return assetAllowedLists;
    }

    @GetMapping("")
    public Header<AssetAllowedListApiResponse> readId(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        AssetAllowedListPK assetAllowedListPK = new AssetAllowedListPK(id, number);
        return assetAllowedListRepository.findById(assetAllowedListPK)
                .map( item->response(item))
                .map(Header::OK)
                .orElseGet( () ->Header.ERROR("데이터 없음") );
    }

    @PostMapping("")
    @ResponseBody
    public Header<AssetAllowedListApiResponse> create(@RequestBody Header<AssetAllowedListApiRequest> request){

        AssetAllowedListApiRequest assetAllowedListApiRequest =request.getData();
        AssetAllowedList assetAllowedList = AssetAllowedList.builder()
                .studentId(assetAllowedListApiRequest.getStudentId())
                .caNumber(assetAllowedListApiRequest.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(assetAllowedListApiRequest.getCreatedBy())
                .updatedAt(assetAllowedListApiRequest.getUpdatedAt())
                .updatedBy(assetAllowedListApiRequest.getUpdatedBy())
                .build();

        //System.out.println(ai.getAiNumber());
        AssetAllowedList newAssetAllowedList = assetAllowedListRepository.save(assetAllowedList);
        return Header.OK(response(newAssetAllowedList));
    }

    @PutMapping("")
    public Header<AssetAllowedListApiResponse> update(@RequestBody Header<AssetAllowedListApiRequest> request){
        AssetAllowedListApiRequest assetAllowedListApiRequest = request.getData();
        AssetAllowedListPK assetAllowedListPK = new AssetAllowedListPK(assetAllowedListApiRequest.getStudentId(), assetAllowedListApiRequest.getCaNumber());
        Optional<AssetAllowedList> optional = assetAllowedListRepository.findById(assetAllowedListPK);


        return optional.map(list -> {
            list
                    .setStudentId(assetAllowedListApiRequest.getStudentId())
                    .setCaNumber(assetAllowedListApiRequest.getCaNumber())
                    .setCreatedAt(assetAllowedListApiRequest.getCreatedAt())
                    .setUpdatedBy(assetAllowedListApiRequest.getUpdatedBy())
                    .setUpdatedAt(assetAllowedListApiRequest.getUpdatedAt())
                    .setUpdatedAt(assetAllowedListApiRequest.getUpdatedAt());
            return list;
        })
                .map(list -> assetAllowedListRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @DeleteMapping("")
    public Header delete(@RequestParam(name = "id") Integer id, @RequestParam(name = "number") Integer number){
        AssetAllowedListPK assetAllowedListPK = new AssetAllowedListPK(id, number);
        System.out.println("Delete id : "+id);
        Optional<AssetAllowedList> optional = assetAllowedListRepository.findById(assetAllowedListPK);

        return optional.map( item ->{
            assetAllowedListRepository.delete(item);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    public AssetAllowedListApiResponse response(AssetAllowedList assetAllowedList){

        AssetAllowedListApiResponse assetAllowedListApiResponse = AssetAllowedListApiResponse.builder()
                .studentId(assetAllowedList.getStudentId())
                .caNumber(assetAllowedList.getCaNumber())
                .createdAt(assetAllowedList.getCreatedAt())
                .createdBy(assetAllowedList.getCreatedBy())
                .updatedAt(assetAllowedList.getUpdatedAt())
                .updatedBy(assetAllowedList.getUpdatedBy())
                .build();




        return assetAllowedListApiResponse;
    }
}
