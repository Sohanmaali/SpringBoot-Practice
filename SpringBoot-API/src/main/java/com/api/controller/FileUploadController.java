package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.helper.FileUploadHelper;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @SuppressWarnings("null")
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getName());

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file Upload kar pahle");
        }
        // file upload
        try {
            if (fileUploadHelper.uploadFile(file)) {
                // return ResponseEntity.ok("file upload successFully");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images")
                        .path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file upload fail Fail");

    }
}
