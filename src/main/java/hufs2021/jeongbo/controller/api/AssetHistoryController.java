package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetHistory;
import hufs2021.jeongbo.model.entity.AssetHistory;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.AssetHistoryApiRequest;
import hufs2021.jeongbo.model.network.request.AssetHistoryApiRequest;
import hufs2021.jeongbo.model.network.response.AssetHistoryApiResponse;
import hufs2021.jeongbo.model.network.response.AssetHistoryApiResponse;
import hufs2021.jeongbo.repository.AssetHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assetHistory/history") // localhost:8080/api/assetHistory/history
public class AssetHistoryController {
    @Autowired
    AssetHistoryRepository assetHistoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetHistory> read(){
        return assetHistoryRepository.findAll();
    }

    @GetMapping("")
    public Header<AssetHistoryApiResponse> readId(@RequestParam(name = "id") Integer id){
        return assetHistoryRepository.findById(id)
                .map( item->response(item))
                .map(Header::OK)
                .orElseGet( () ->Header.ERROR("데이터 없음") );
    }

    @PostMapping("")
    @ResponseBody
    public Header<AssetHistoryApiResponse> create(@RequestBody Header<AssetHistoryApiRequest> request){
        AssetHistoryApiRequest assetHistoryApiRequest =request.getData();

        AssetHistory assetHistory = AssetHistory.builder()
                .ahNumber(assetHistoryApiRequest.getAhNumber())
                .ahAiNumber(assetHistoryApiRequest.getAhAiNumber())
                .ahApplicationdate(assetHistoryApiRequest.getAhApplicationdate())
                .ahReturndate(assetHistoryApiRequest.getAhReturndate())
                .studentId(assetHistoryApiRequest.getStudentId())
                .createdAt(LocalDateTime.now())
                .createdBy(assetHistoryApiRequest.getCreatedBy())
                .updatedAt(assetHistoryApiRequest.getUpdatedAt())
                .updatedBy(assetHistoryApiRequest.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        AssetHistory newAsset = assetHistoryRepository.save(assetHistory);


        //System.out.println(ai.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<AssetHistoryApiResponse> update(@RequestBody Header<AssetHistoryApiRequest> request){
        //Optional<AssetHistory> assetInventoryById = assetHistoryRepository.findById(id); // 한 raw 데이터 받기
        AssetHistoryApiRequest assetHistoryApiRequest =request.getData();


        Optional<AssetHistory> optional = assetHistoryRepository.findById(assetHistoryApiRequest.getAhNumber());


        return optional.map(list -> {
            list
                    .setAhNumber(assetHistoryApiRequest.getAhNumber())
                    .setAhAiNumber(assetHistoryApiRequest.getAhAiNumber())
                    .setAhApplicationdate(assetHistoryApiRequest.getAhApplicationdate())
                    .setAhReturndate(assetHistoryApiRequest.getAhReturndate())
                    .setStudentId(assetHistoryApiRequest.getStudentId())
                    .setCreatedAt(assetHistoryRepository.findById(assetHistoryApiRequest.getAhNumber()).get().getCreatedAt())
                    .setCreatedBy(assetHistoryRepository.findById(assetHistoryApiRequest.getAhNumber()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(assetHistoryApiRequest.getUpdatedBy());
            return list;
        })
                .map(list -> assetHistoryRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        Optional<AssetHistory> optional = assetHistoryRepository.findById(id);

        return optional.map( item ->{
            assetHistoryRepository.delete(item);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }
    public AssetHistoryApiResponse response(AssetHistory assetHistory){

        AssetHistoryApiResponse assetAllowedListApiResponse = AssetHistoryApiResponse.builder()
                .ahNumber(assetHistory.getAhNumber())
                .ahAiNumber(assetHistory.getAhAiNumber())
                .ahApplicationdate(assetHistory.getAhApplicationdate())
                .ahReturndate(assetHistory.getAhReturndate())
                .studentId(assetHistory.getStudentId())
                .createdAt(assetHistory.getCreatedAt())
                .createdBy(assetHistory.getCreatedBy())
                .updatedAt(assetHistory.getUpdatedAt())
                .updatedBy(assetHistory.getUpdatedBy())
                .build();
      return assetAllowedListApiResponse;
    }
}