package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.emums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties prop;

//    private static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg", "image/png", "image/bmp");

    public String uploadImage(MultipartFile file) {
        try {
            //校验文件类型
            String contentType = file.getContentType();
            System.out.println(contentType);
            if (!prop.getAllowTypes().contains(contentType)) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //准备目标路径
//            //this.getClass().getClassLoader().getResource("").getFile();
//            File dest = new File("C:\\Users\\CHEN\\Desktop\\leyou.git\\upload", file.getOriginalFilename());
//            //保存文件到本地
//            file.transferTo(dest);

            //上传到FastDFS
            //String extendion = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            String extendion = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extendion, null);


            //返回路径
            return prop.getBaseUrl() + storePath.getFullPath();
        } catch (IOException e) {
            log.error("[文件上传] 上传文件失败", e);
            throw new LyException(ExceptionEnum.UPLOAD_ERROR);
        }


    }
}
