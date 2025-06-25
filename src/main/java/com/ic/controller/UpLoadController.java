package com.ic.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UpLoadController {
    @PostMapping("/upimage")
    public String upLoad(MultipartFile f, String name, HttpServletRequest request) throws IOException
    {
        System.out.println(name);
        System.out.println(f.getContentType());
        System.out.println(f.getOriginalFilename());
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);

        return "compelet";
    }
    public void saveFile(MultipartFile f, String path) throws IOException
    {
        File dir = new File(path);
        if(!dir.exists())
        {
            dir.mkdir();
        }

        File file = new File(path + f.getOriginalFilename());
        f.transferTo(file);
    }
}
