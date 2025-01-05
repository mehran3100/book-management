package com.mehran.KTBooks.service;

import com.mehran.KTBooks.models.entity.UploadedFile;
import com.mehran.KTBooks.repository.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public UploadedFile uploadFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, originalFilename);

        // Save file to file system
        Files.copy(file.getInputStream(), filePath);

        // Save metadata to database
        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFilename(originalFilename);
        uploadedFile.setFilepath(filePath.toString());
        uploadedFile.setContentType(file.getContentType());
        uploadedFile.setSize(file.getSize());
        uploadedFile.setUploadTime(LocalDateTime.now());
        return fileRepository.save(uploadedFile);
    }

    public byte[] downloadFile(String filename) throws IOException {
        UploadedFile fileRecord = fileRepository.findByFilename(filename);
        if (fileRecord == null) {
            throw new IOException("File not found");
        }
        Path filePath = Paths.get(fileRecord.getFilepath());
        return Files.readAllBytes(filePath);
    }
}