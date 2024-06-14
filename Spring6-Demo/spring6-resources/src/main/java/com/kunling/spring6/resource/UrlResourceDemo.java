package com.kunling.spring6.resource;

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;

// 演示UrlResource 访问网络资源
public class UrlResourceDemo {


    public static void main(String[] args) {
        // http前缀开头
//        loadUrlResource("http://www.baidu.com");
        // file前缀
        loadUrlResource("file:kunling.txt");
    }

    // 访问前缀是http、flie
    public static void loadUrlResource(String path) {
        // 创建Resource实现类对象 UrlResource
        try {
            UrlResource url = new UrlResource(path);

            // 获取资源相关信息
            System.out.println(url.getFilename());
            System.out.println(url.getURL());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
