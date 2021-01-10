package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.AssetNotice;
import hufs2021.jeongbo.model.entity.AssetNotice;
import hufs2021.jeongbo.model.entity.AssetNotice;
import hufs2021.jeongbo.model.network.Header;
import hufs2021.jeongbo.model.network.request.AssetNoticeApiRequest;
import hufs2021.jeongbo.model.network.request.AssetNoticeApiRequest;
import hufs2021.jeongbo.model.network.response.AssetNoticeApiResponse;
import hufs2021.jeongbo.model.network.response.AssetNoticeApiResponse;
import hufs2021.jeongbo.repository.AssetNoticeRepository;
import hufs2021.jeongbo.repository.AssetNoticeRepository;
import hufs2021.jeongbo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/notice") // localhost:8080/api/notice
public class AssetNoticeController {
    @Autowired
    AssetNoticeRepository assetNoticeRepository;

    @GetMapping("/all")
    @ResponseBody
    public List<AssetNotice> read(){
        return assetNoticeRepository.findAll();
    }

    @GetMapping("")
    public Header<AssetNoticeApiResponse> readId(@RequestParam(name = "id") Integer id){
        return assetNoticeRepository.findById(id)
                .map( item->response(item))
                .map(Header::OK)
                .orElseGet( () ->Header.ERROR("데이터 없음") );
    }

    @PostMapping("")
    @ResponseBody
    public Header<AssetNoticeApiResponse> create(@RequestBody Header<AssetNoticeApiRequest> request){
        AssetNoticeApiRequest assetNoticeApiRequest =request.getData();

        AssetNotice assetNotice = AssetNotice.builder()
                .anNumber(assetNoticeApiRequest.getAnNumber())
                .anContent(assetNoticeApiRequest.getAnContent())
                .createdAt(LocalDateTime.now())
                .createdBy(assetNoticeApiRequest.getCreatedBy())
                .updatedAt(assetNoticeApiRequest.getUpdatedAt())
                .updatedBy(assetNoticeApiRequest.getUpdatedBy())
                .build();
        //System.out.println(assetNoticeApiRequest.getAiNumber());
        AssetNotice newAsset = assetNoticeRepository.save(assetNotice);


        //System.out.println(assetNoticeApiRequest.getAiNumber());
        return Header.OK(response(newAsset));
    }

    @PutMapping("")
    public Header<AssetNoticeApiResponse> update(@RequestBody Header<AssetNoticeApiRequest> request){
        //Optional<AssetNotice> assetInventoryById = assetNoticeRepository.findById(id); // 한 raw 데이터 받기
        AssetNoticeApiRequest assetNoticeApiRequest =request.getData();


        Optional<AssetNotice> optional = assetNoticeRepository.findById(assetNoticeApiRequest.getAnNumber());


        return optional.map(list -> {
            list
                    .setAnNumber(assetNoticeApiRequest.getAnNumber())
                    .setAnContent(assetNoticeApiRequest.getAnContent())
                    .setCreatedAt(assetNoticeRepository.findById(assetNoticeApiRequest.getAnNumber()).get().getCreatedAt())
                    .setCreatedBy(assetNoticeRepository.findById(assetNoticeApiRequest.getAnNumber()).get().getCreatedBy())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy(assetNoticeApiRequest.getUpdatedBy());
            return list;
        })
                .map(list -> assetNoticeRepository.save(list))
                .map(list -> response(list))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable(name = "id") Integer id){
        System.out.println("Delete id : "+id);
        Optional<AssetNotice> optional = assetNoticeRepository.findById(id);

        return optional.map( item ->{
            assetNoticeRepository.delete(item);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }
    public AssetNoticeApiResponse response(AssetNotice assetNotice){

        AssetNoticeApiResponse assetAllowedListApiResponse = AssetNoticeApiResponse.builder()
                .anNumber(assetNotice.getAnNumber())
                .anContent(assetNotice.getAnContent())
                .createdAt(assetNotice.getCreatedAt())
                .createdBy(assetNotice.getCreatedBy())
                .updatedAt(assetNotice.getUpdatedAt())
                .updatedBy(assetNotice.getUpdatedBy())
                .build();
        return assetAllowedListApiResponse;
    }
}