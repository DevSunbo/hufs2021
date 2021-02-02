package hufs2021.jeongbo.controller.apiXXXXXXX;

import hufs2021.jeongbo.model.entity.Asset;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.AssetApiRequest;
import hufs2021.jeongbo.model.network.response.AssetApiResponse;
import hufs2021.jeongbo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asset") // localhost:8080/api/asset
public class AssetController {
    @Autowired
    AssetRepository assetRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<Asset> read(){
        return assetRepository.findAll();
    }

    @GetMapping("")
    public Header<AssetApiResponse> readId(@RequestParam(name = "id") Integer id){
        return assetRepository.findById(id)
                .map( item->response(item))
                .map(Header::OK)
                .orElseGet( () ->Header.ERROR("데이터 없음") );
    }

    @PostMapping("")
    @ResponseBody
    public Header<AssetApiResponse> create(@RequestBody Header<AssetApiRequest> request){
        AssetApiRequest assetApiRequest =request.getData();

        Asset asset = Asset.builder()
                .aId(assetApiRequest.getAId())
                .aMajor(assetApiRequest.getAMajor())
                .aGrade(assetApiRequest.getAGrade())
                .aDeadline(assetApiRequest.getADeadline())
                .caNumber(assetApiRequest.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(assetApiRequest.getCreatedBy())
                .updatedAt(assetApiRequest.getUpdatedAt())
                .updatedBy(assetApiRequest.getUpdatedBy())
                .build();
        //System.out.println(ai.getAiNumber());
        Asset newAsset = assetRepository.save(asset);


        //System.out.println(ai.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<AssetApiResponse> update(@RequestBody Header<AssetApiRequest> request){
        //Optional<Asset> assetInventoryById = assetRepository.findById(id); // 한 raw 데이터 받기
        AssetApiRequest assetApiRequest =request.getData();
        Optional<Asset> optional = assetRepository.findById(assetApiRequest.getAId());


        return optional.map(list -> {
            list
                    .setAId(assetApiRequest.getAId())
                    .setAMajor(assetApiRequest.getAMajor())
                    .setAGrade(assetApiRequest.getAGrade())
                    .setADeadline(assetApiRequest.getADeadline())
                    .setCaNumber(assetApiRequest.getCaNumber())
                    .setCreatedAt(assetRepository.findById(assetApiRequest.getAId()).get().getCreatedAt())
                    .setCreatedBy(assetRepository.findById(assetApiRequest.getAId()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(assetApiRequest.getUpdatedBy());
            return list;
        })
                .map(list -> assetRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        Optional<Asset> optional = assetRepository.findById(id);

        return optional.map( item ->{
            assetRepository.delete(item);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }
    public AssetApiResponse response(Asset asset){

        AssetApiResponse assetAllowedListApiResponse = AssetApiResponse.builder()
                .aId(asset.getAId())
                .aMajor(asset.getAMajor())
                .aGrade(asset.getAGrade())
                .aDeadline(asset.getADeadline())
                .caNumber(asset.getCaNumber())
                .createdAt(LocalDateTime.now())
                .createdBy(asset.getCreatedBy())
                .updatedAt(asset.getUpdatedAt())
                .updatedBy(asset.getUpdatedBy())
                .build();




        return assetAllowedListApiResponse;
    }
}
