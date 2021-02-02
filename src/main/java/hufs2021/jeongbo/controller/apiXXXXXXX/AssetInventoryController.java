package hufs2021.jeongbo.controller.apiXXXXXXX;

import hufs2021.jeongbo.model.entity.AssetInventory;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.AssetInventoryApiRequest;
import hufs2021.jeongbo.model.network.response.AssetInventoryApiResponse;
import hufs2021.jeongbo.repository.AssetInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asset/inventory") // localhost:8080/api/asset/inventory
public class AssetInventoryController {
    @Autowired
    AssetInventoryRepository assetInventoryRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetInventory> read(){
        return assetInventoryRepository.findAll();
    }

    @GetMapping("")
    public Header<AssetInventoryApiResponse> readId(@RequestParam(name = "id") Integer id){
        return assetInventoryRepository.findById(id)
                .map( item->response(item))
                .map(Header::OK)
                .orElseGet( () ->Header.ERROR("데이터 없음") );
    }

    @PostMapping("")
    @ResponseBody
    public Header<AssetInventoryApiResponse> create(@RequestBody Header<AssetInventoryApiRequest> request){
        AssetInventoryApiRequest assetInventoryApiRequest =request.getData();

        AssetInventory assetInventory = AssetInventory.builder()
                .aiNumber(assetInventoryApiRequest.getAiNumber())
                .aiSerial(assetInventoryApiRequest.getAiSerial())
                .aiExpiration(assetInventoryApiRequest.getAiExpiration())
                .aiStatus(assetInventoryApiRequest.getAiStatus())
                .aiRoom(assetInventoryApiRequest.getAiRoom())
                .aiUser(assetInventoryApiRequest.getAiUser())
                .caNumber(assetInventoryApiRequest.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(assetInventoryApiRequest.getCreatedBy())
                .updatedAt(assetInventoryApiRequest.getUpdatedAt())
                .updatedBy(assetInventoryApiRequest.getUpdatedBy())
                .build();
        //System.out.println(assetInventoryApiRequest.getAiNumber());
        AssetInventory newAsset = assetInventoryRepository.save(assetInventory);


        //System.out.println(assetInventoryApiRequest.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<AssetInventoryApiResponse> update(@RequestBody Header<AssetInventoryApiRequest> request){
        //Optional<AssetInventory> assetInventoryById = assetInventoryRepository.findById(id); // 한 raw 데이터 받기
        AssetInventoryApiRequest assetInventoryApiRequest =request.getData();


        Optional<AssetInventory> optional = assetInventoryRepository.findById(assetInventoryApiRequest.getAiNumber());


        return optional.map(list -> {
            list
                    .setAiNumber(assetInventoryApiRequest.getAiNumber())
                    .setAiSerial(assetInventoryApiRequest.getAiSerial())
                    .setAiExpiration(assetInventoryApiRequest.getAiExpiration())
                    .setAiStatus(assetInventoryApiRequest.getAiStatus())
                    .setAiRoom(assetInventoryApiRequest.getAiRoom())
                    .setAiUser(assetInventoryApiRequest.getAiUser())
                    .setCaNumber(assetInventoryApiRequest.getCaNumber())
                    .setCreatedAt(assetInventoryRepository.findById(assetInventoryApiRequest.getAiNumber()).get().getCreatedAt())
                    .setCreatedBy(assetInventoryRepository.findById(assetInventoryApiRequest.getAiNumber()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(assetInventoryApiRequest.getUpdatedBy());
            return list;
        })
                .map(list -> assetInventoryRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        Optional<AssetInventory> optional = assetInventoryRepository.findById(id);

        return optional.map( item ->{
            assetInventoryRepository.delete(item);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }
    public AssetInventoryApiResponse response(AssetInventory assetInventory){

        AssetInventoryApiResponse assetAllowedListApiResponse = AssetInventoryApiResponse.builder()
                .aiNumber(assetInventory.getAiNumber())
                .aiSerial(assetInventory.getAiSerial())
                .aiExpiration(assetInventory.getAiExpiration())
                .aiStatus(assetInventory.getAiStatus())
                .aiRoom(assetInventory.getAiRoom())
                .aiUser(assetInventory.getAiUser())
                .caNumber(assetInventory.getCaNumber())
                .createdAt(assetInventory.getCreatedAt())
                .createdBy(assetInventory.getCreatedBy())
                .updatedAt(assetInventory.getUpdatedAt())
                .updatedBy(assetInventory.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}