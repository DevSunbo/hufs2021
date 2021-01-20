package hufs2021.jeongbo.service;

import hufs2021.jeongbo.model.entity.File;
import hufs2021.jeongbo.network.Header;
import hufs2021.jeongbo.network.request.FileRequest;
import hufs2021.jeongbo.network.response.FileResponse;
import hufs2021.jeongbo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public Header<FileResponse> create(FileRequest fileRequest) {

        File file = File.builder()
                .fName(fileRequest.getFName())
                .createdAt(LocalDateTime.now())
                .createdBy(1234)
                .build();

        File newFile = fileRepository.save(file);

        if(newFile!=null)
            return Header.OK(response(newFile));
        else
            return Header.ERROR();
    }

    public Header<FileResponse> readAll() {
        List<File> fileList = fileRepository.findAll();

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
        return Header.ERROR();
    }

    public Header<FileResponse> read(Integer id) {
        return fileRepository.findById(id).map(file -> {
            System.out.println("파일 아디: " + file.getFId());
            System.out.println("파일 명: " + file.getFName());
            System.out.println("등록일: " + file.getCreatedAt());
            System.out.println("등록자: " + file.getCreatedBy());
            System.out.println("---------------");
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);
    }

    public Header<FileResponse> update(FileRequest fileRequest) {

        return fileRepository.findById(fileRequest.getFId()).map(file -> {
            file.setFName(fileRequest.getFName());
            file.setUpdatedAt(LocalDateTime.now());
            file.setUpdatedBy(fileRequest.getUpdatedBy());

            File updatedFile = fileRepository.save(file);
            return Header.OK(response(updatedFile));
        }).orElseGet(Header::ERROR);
    }

    public Header<FileResponse> delete(Integer id){
        return fileRepository.findById(id).map(file -> {
            fileRepository.delete(file);
            return Header.OK(response(file));
        }).orElseGet(Header::ERROR);
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

}
