package com.zpself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zengpeng on 2019/3/28
 */
@SpringBootApplication
@RestController
public class KafakaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafakaApplication.class, args);
    }

    @GetMapping("/upload")//上传
    public String upload(){
        return "upload";
    }

    @GetMapping("/download")//下载
    public String download() throws Exception{
        System.out.println("AAA");
        return "download";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world！";
    }
}
