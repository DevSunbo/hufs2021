package hufs2021.jeongbo.controller.apiXXXXXXX;

import hufs2021.jeongbo.model.entity.File;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.FileRequest;
import hufs2021.jeongbo.network.response.FileResponse;
import hufs2021.jeongbo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/file", produces = "application/json")
public class FileController {

//    @Autowired
//    private FileRepository fileRepository;

    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    @ResponseBody
    public Header<FileResponse> create(@RequestBody FileRequest fileRequest) {

        /*File file = File.builder()
                .fName(fileRequest.getFName())
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

        File newFile = fileRepository.save(file);

        if(newFile!=null)
            return Header.OK(response(newFile));
        else
            return Header.ERROR();*/
        return fileService.create(fileRequest);
    }

    @GetMapping("/readall")
    @ResponseBody
    public Header<FileResponse> readAll() {
        /*List<File> fileList = fileRepository.findAll();

        if(fileList!=null){
            fileList.stream().forEach(file -> {
                System.out.println("파일 아이디: " + file.getFId());
                System.out.println("파일 명: " + file.getFName());
                System.out.println("등록일: " + file.getCreatedAt());
                System.out.println("등록자: " + file.getCreatedBy());
                System.out.println("---------------");
            });
            return Header.OK();
        }
        return Header.ERROR();*/
        return fileService.readAll();
    }

    @GetMapping("/read")
    public Header<FileResponse> read(@RequestParam Integer id) {
        /*return fileRepository.findById(id).map(file -> {
            System.out.println("파일 아디: " + file.getFId());
            System.out.println("파일 명: " + file.getFName());
            System.out.println("등록일: " + file.getCreatedAt());
            System.out.println("등록자: " + file.getCreatedBy());
            System.out.println("---------------");
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);*/
        return fileService.read(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public Header<FileResponse> update(@RequestBody FileRequest fileRequest) {

        /*return fileRepository.findById(fileRequest.getFId()).map(file -> {
            file.setFName(fileRequest.getFName());
            file.setUpdatedAt(LocalDateTime.now());
            file.setUpdatedBy(fileRequest.getUpdatedBy());

            File updatedFile = fileRepository.save(file);
            return Header.OK(response(updatedFile));
        }).orElseGet(Header::ERROR);*/
        return fileService.update(fileRequest);
    }

    @DeleteMapping("/delete")
    public Header<FileResponse> delete(@RequestParam Integer id){
        /*return fileRepository.findById(id).map(file -> {
            fileRepository.delete(file);
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);*/
        return fileService.delete(id);
    }

    private FileResponse response(File file) {
        return FileResponse.builder()
                .fId(file.getFId())
                .fName(file.getFName())
                .createdAt(file.getCreatedAt())
                .createdBy(file.getCreatedBy())
                .updatedAt(file.getUpdatedAt())
                .updatedBy(file.getUpdatedBy())
                .build();
    }

    private FileResponse response(List<File> fileList) { //안됨
        List<FileResponse> fileResponseList = new ArrayList<>();

        fileList.stream().forEach(file -> {
            FileResponse fileResponse = FileResponse.builder()
                    .fId(file.getFId())
                    .fName(file.getFName())
                    .createdAt(file.getCreatedAt())
                    .createdBy(file.getCreatedBy())
                    .updatedAt(file.getUpdatedAt())
                    .updatedBy(file.getUpdatedBy())
                    .build();

            fileResponseList.add(fileResponse);
        });

        return (FileResponse) fileResponseList;
    }


}
