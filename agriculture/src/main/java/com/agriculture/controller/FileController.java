package com.agriculture.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

//    @Value("${files.upload.path}")
//    private String fileUploadPath;
//
    @Value("${server.port}")
    private String port;

//    private String ip = "localhost";
//
//    @Resource
//    private FileMapper fileMapper;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Value("${file.path}")
    private String filepath;


    /**
     * 文件上传接口
     *
     * @param file 前端传递过来的文件
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();  // 获取源文件的名称
//        // 定义文件的唯一标识（前缀）
//        String flag = IdUtil.fastSimpleUUID();
//        String rootFilePath = System.getProperty("user.dir") + "/file/" + flag + "_" + originalFilename;  // 获取上传的路径
//        FileUtil.writeBytes(file.getBytes(), rootFilePath);  // 把文件写入到上传的路径
//        String url = "http://" + ip + ":" + port + "/file/" + flag;
////        return Result.success(url);  // 返回结果 url
//        System.out.println(url);
//        return url;


        // 获取文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
// 生成新文件
        fileName = IdUtil.fastSimpleUUID() + suffixName;
        String url = null;

// 存新上传的图片
        System.out.println(1);
        File dest = new File(filepath, fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
            System.out.println("if");
        }
        try {
            file.transferTo(dest);
            url = "http://localhost" + ":" + port + "" + "/file/" + fileName;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("return");
        return url;
    }
}

