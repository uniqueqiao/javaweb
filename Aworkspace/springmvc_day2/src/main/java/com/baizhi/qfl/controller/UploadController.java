package com.baizhi.qfl.controller;

import com.baizhi.qfl.util.UUIDUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class UploadController {
    @RequestMapping("upload")
    public String upload(MultipartFile avatar,HttpSession session,HttpServletRequest request) throws IOException {
        if(avatar == null || avatar.getSize() == 0){
            //用户未上传文件或者上传的文件大小为0（大小为0的文件没有上传的意义）
            request.setAttribute("errorMess", "请选择文件");
            return "upload";
        }
        boolean isImage = avatar.getContentType().startsWith("image/");
        if (isImage==false) {
            request.setAttribute("errorMess", "上传的非图片");
            return "upload";
        }
        String path=session.getServletContext().getRealPath("/static/avatar");
        //原始文件名
        String fileName = avatar.getOriginalFilename();
        //获取扩展名
        String ext = FilenameUtils.getExtension(fileName);
        //新名字
        String newFileName=FilenameUtils.getBaseName(fileName)+"."+ UUIDUtil.getUUID()+"."+ext;
        avatar.transferTo(new File(path,newFileName));
        return "index";
    }
}
