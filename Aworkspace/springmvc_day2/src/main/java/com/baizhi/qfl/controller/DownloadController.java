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
public class DownloadController {
    @RequestMapping("download")
    public String upload(MultipartFile avatar,HttpSession session,HttpServletRequest request) throws IOException {

        return "index";
    }
}
