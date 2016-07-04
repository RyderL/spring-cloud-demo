package com.ai5suoai.file.v1;

import com.ai5suoai.file.service.FileService;
import com.ai5suoai.file.service.UploadResult;

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
 * @author chenzhenjia
 * @since 16/7/1
 */
@RequestMapping("/v1/files")
@RestController
public class FileCtrl {

    @Autowired
    FileService fileService;
    private static final Logger log = LoggerFactory.getLogger(FileCtrl.class);

    /**
     * 上传文件
     *
     * @param dir  文件夹
     * @param file 文件对象
     */
    @RequestMapping(value = "/{dir}", method = RequestMethod.POST)
    public ResponseEntity upload(
            @PathVariable("dir") String dir,
            MultipartFile file) throws IOException {
        UploadResult result = fileService.upload(dir, file);
        result.add(linkTo(FileCtrl.class).withSelfRel());
        result.add(new Link(result.getUrl(), "file"));
        return ResponseEntity.ok(result);

    }
}
