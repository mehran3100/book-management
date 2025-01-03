package com.mehran.KTBooks.repository;

import com.mehran.KTBooks.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<UploadedFile, Long> {
    UploadedFile findByFilename(String filename);
}