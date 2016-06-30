package com.ai5suoai.file.qiniu;

import com.ai5suoai.file.FileService;
import com.ai5suoai.file.qiniu.entity.QiNiu;
import com.qiniu.http.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * 文件的 controller
 *
 * @author chenzhenjia
 * @since 16/6/29
 */
@RestController
@RequestMapping("/v1/files/")
public class QiNiuFileCtrl {

    @Autowired
    QiNiu qiNiu;
    @Autowired
    FileService fileService;
    private static final Logger log = LoggerFactory.getLogger(QiNiuFileCtrl.class);

    /**
     * 上传文件
     *
     * @param dir  文件夹
     * @param file 文件对象
     */
    @RequestMapping(value = "{dir}", method = RequestMethod.POST)
    public ResponseEntity upload(
            @PathVariable("dir") String dir,
            MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        log.info("上传文件文件夹名:{},文件大小为:{},远程文件名为:{},", dir, file.getSize(), originalFilename);
        String suffix = "";
        if (originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.indexOf("."));
        }
        String fileKey = dir + "/" + fileService.getMD5ByByte(file.getBytes()) + suffix;
        log.info("上传文件上传的文件key为:{}", fileKey);
        Response response = qiNiu.getUploadManager().put(file.getBytes(), fileKey, qiNiu.getDefaultToken());
        if (response.isOK())
            log.info("上传文件成功,文件的key为:{},结果为:{},文件地址为:{}", fileKey, response.bodyString(), qiNiu.getResourceUrl(fileKey));
        UploadResult result = new UploadResult();
        result.setUrl(qiNiu.getResourceUrl(fileKey));
        result.add(linkTo(QiNiuFileCtrl.class).withSelfRel());
        result.add(new Link(result.getUrl(), "file"));
        return ResponseEntity.ok(result);

    }

}
