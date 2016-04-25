package ru.kpfu.driving_school.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by etovladislav on 09.04.16.
 */
public class ImageUploadProvider {

    public String upload(MultipartFile file, String dirName) {
        File dir = null;
        String newFileName = null;
        if (!file.isEmpty() && (file != null)) {
            try {
                byte[] bytes = file.getBytes();
                dir = new File(PropertyPath.userDirectory + File.separator + dirName);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                newFileName = UUID.randomUUID().toString() + "."
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + newFileName);
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newFileName;
    }
}
