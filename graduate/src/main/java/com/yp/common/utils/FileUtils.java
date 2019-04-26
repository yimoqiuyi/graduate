package com.yp.common.utils;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    //上传房间图片,返回路径
    public String UploadRoomPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String roomPath = path + fileName;
        File files = new File(roomPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("上传成功");
        } catch (IOException e) {
            System.out.print("上传失败");
            e.printStackTrace();
        }
        return roomPath;
    }

    //上传栋图片
    public String UplodeBuildingPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String buildPath = path + fileName;
        File files = new File(buildPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("上传成功");
        } catch (IOException e) {
            System.out.print("上传失败");
            e.printStackTrace();
        }
        return buildPath;
    }

    //上传分园区图片
    public String UploadSubparkPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String subParkPath = path + fileName;
        File files = new File(subParkPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("上传成功");
        } catch (IOException e) {
            System.out.print("上传失败");
            e.printStackTrace();
        }
        return subParkPath;
    }

    //上传总园区图片
    public String UploadGeneralPicture(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        String path = "D:/IdeaProjects/picture/";
        String generalPath = path + fileName;
        File files = new File(generalPath);
        try {
            multipartFile.transferTo(files);
            System.out.print("上传成功");
        } catch (IOException e) {
            System.out.print("上传失败");
            e.printStackTrace();
        }
        return generalPath;
    }

    //上传单个文件，返回文件路径
    public String UploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        file.getContentType();
        String path = "D:/IdeaProjects/file/";
        String filePath = path + fileName;
        File files = new File(filePath);
        try {
            file.transferTo(files);
            System.out.print("上传成功");
        } catch (IOException e) {
            System.out.print("上传失败");
            e.printStackTrace();
        }
        return filePath;
    }

    //上传多个文件，返回文件路径集合
    public List<String> UploadFiles(MultipartFile[] multipartFiles) throws IOException {
        List<File> list = new ArrayList<File>();
        List<String> slist = new ArrayList<String>();
        File file = null;
        String filesPath;
        String path = "D:/IdeaProjects/file/";
        for (int i = 0; i < multipartFiles.length; i++) {
            String name = multipartFiles[i].getOriginalFilename();
            filesPath = path + name;
            file = new File(filesPath);
            multipartFiles[i].transferTo(file);
            slist.add(filesPath);
        }
        return slist;
    }

    public String downFile(String fileName, String path, HttpServletResponse response) {

        try {
            fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");

            String name = fileName + ".xlsx";
//             // 获取上传文件的目录
//            ServletContext sc = request.getSession().getServletContext();
//            System.out.println("4");
//            // 上传位置
//            String fileSaveRootPath = sc.getRealPath("/img");
//
//            System.out.println(fileSaveRootPath + "\\" + fileName);
            // 得到要下载的文件
            File file = new File(path);

            // 如果文件不存在
            if (!file.exists()) {
                System.out.println("您要下载的资源已被删除！！");
                return "error";
            }
            // 处理文件名
            String realname = name.substring(fileName.indexOf("_") + 1);
            // 设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode(realname, "UTF-8"));
            // 读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(path + "\\" + fileName);
            // 创建输出流
            OutputStream out = response.getOutputStream();
            // 创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                // 输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            // 关闭文件输入流
            in.close();
            // 关闭输出流
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

}
