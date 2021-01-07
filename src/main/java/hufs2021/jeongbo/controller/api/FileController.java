package hufs2021.jeongbo.controller.api;

import hufs2021.jeongbo.model.entity.File;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.FileRequest;
import hufs2021.jeongbo.network.response.FileResponse;
import hufs2021.jeongbo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/file", produces = "application/json")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @PostMapping("/create")
    @ResponseBody
    public Header<FileResponse> create(@RequestBody FileRequest fileRequest) {

        File file = File.builder()
                .fNumber(fileRequest.getFNumber())
                .fName(fileRequest.getFName())
                .createdAt(LocalDateTime.now())
                .createdBy(4321)
                .build();

        File newFile = fileRepository.save(file);

        if(newFile!=null)
            return Header.OK(response(newFile));
        else
            return Header.ERROR();
    }

    @GetMapping("/readall")
    @ResponseBody
    public Header<FileResponse> readAll() {
        List<File> fileList = fileRepository.findAll();

        if(fileList!=null){
            fileList.stream().forEach(file -> {
                System.out.println("파일 아이디: " + file.getFId());
                System.out.println("파일 번호: " + file.getFNumber());
                System.out.println("파일 명: " + file.getFName());
                System.out.println("등록일: " + file.getCreatedAt());
                System.out.println("등록자: " + file.getCreatedBy());
                System.out.println("---------------");
            });
            return Header.OK();
        }
        return Header.ERROR();
    }

    @GetMapping("/read/{f_id}")
    public Header<FileResponse> read(@PathVariable(name = "f_id") Integer id) {
        return fileRepository.findById(id).map(file -> {
            System.out.println("파일 아디: " + file.getFId());
            System.out.println("파일 번호: " + file.getFNumber());
            System.out.println("파일 명: " + file.getFName());
            System.out.println("등록일: " + file.getCreatedAt());
            System.out.println("등록자: " + file.getCreatedBy());
            System.out.println("---------------");
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);
    }

    @GetMapping("/update")
    public Header<FileResponse> update() {
        File newFile = File.builder()
                .fNumber(2)
                .fName("회사 지원서 파일")
                .updatedAt(LocalDateTime.now())
                .updatedBy(4321)
                .build();

        return fileRepository.findById(3).map(file -> {
            file.setFNumber(newFile.getFNumber());
            file.setFName(newFile.getFName());
            file.setUpdatedAt(newFile.getUpdatedAt());
            file.setUpdatedBy(newFile.getUpdatedBy());

            File updatedFile = fileRepository.save(file);
            return Header.OK(response(updatedFile));
        }).orElseGet(Header::ERROR);
    }

    @DeleteMapping("/delete/{f_id}")
    public Header<FileResponse> delete(@PathVariable(name = "f_id") Integer id){
        return fileRepository.findById(id).map(file -> {
            fileRepository.delete(file);
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);
    }

    private FileResponse response(File file) {
        return FileResponse.builder()
                .fId(file.getFId())
                .fNumber(file.getFNumber())
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
                    .fNumber(file.getFNumber())
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
