package com.jobagent.job_agent.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Component
public class FileStorageUtil {

    private static final String UPLOAD_DIR = "uploads";

    public String saveFile(MultipartFile file) throws IOException {

        // Create uploads directory if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Validate PDF
        if (!"application/pdf".equals(file.getContentType())) {
            throw new IllegalArgumentException("Only PDF files are allowed.");
        }

        // Generate unique filename
        String originalFilename = file.getOriginalFilename();

        String uniqueFilename =
                UUID.randomUUID() + "_" + originalFilename;

        Path filePath = uploadPath.resolve(uniqueFilename);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING
        );

        return filePath.toString();
    }

}
