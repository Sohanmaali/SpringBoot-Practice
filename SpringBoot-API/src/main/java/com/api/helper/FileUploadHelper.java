package com.api.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public static final String FILE_PATH =
    // "D:\\Spring-Boot\\SpringBoot-API\\src\\main\\resources\\static\\Images";

    public final String FILE_PATH = new ClassPathResource("static/Images/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
        super();
    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean b = false;
        try {

            // First Way
            // InputStream is = multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // FileOutputStream fos = new FileOutputStream(
            // FILE_PATH + File.separator + multipartFile.getOriginalFilename());

            // fos.write(data);
            // fos.flush();
            // fos.close();

            // Second Way
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(FILE_PATH + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            b = true;
            return b;
        } catch (Exception e) {
            System.out.println(e);
        }

        return b;

    }
}
