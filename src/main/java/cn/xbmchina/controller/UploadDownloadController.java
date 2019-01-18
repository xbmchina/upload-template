package cn.xbmchina.controller;

import cn.xbmchina.util.DownloadUtil;
import cn.xbmchina.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class UploadDownloadController {

    @Value("${upload.file-path}")
    private String dirPath;

    @RequestMapping("/upload")
    public Map<String, Object> upload(MultipartFile[] files) throws Exception {
        return UploadUtil.upload(files, dirPath);
    }

    @RequestMapping("/download/{path}")
    public void download(@PathVariable String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
         DownloadUtil.download(dirPath+path,request,response);
    }


}
