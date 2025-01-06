package com.mehran.KTBooks.repositories;

import com.mehran.KTBooks.models.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<UploadedFile, Long> {
    UploadedFile findByFilename(String filename);
}