package com.test.sqlserver.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



/**
 * 封装遍历文件方法
 *
 */
public class FileListUtil {

    /**
     * 遍历目标目录文件并保存
     *
     * @param fileList 存放文件集合
     * @param path     遍历目录的地址
     * @return
     */
    public List<File> getFiles(List<File> fileList, String path) {
        try {
            File file = new File(path);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File fileIndex : files) {
                    //如果这个文件是目录，则进行递归搜索
                    if (fileIndex.isDirectory()) {
                        getFiles(fileList, fileIndex.getPath());
                    } else {
                        //如果文件是普通文件，则将文件句柄放入集合中
                        fileList.add(fileIndex);
                    }
                }
            }
        } catch (Exception e) {

        }
        return fileList;
    }

    /**
     * 遍历文件集合，获取文件名，将获取到的文件名保存进list集合
     *
     * @param fileList 获取到文件集合
     * @return
     */
    public List<String> getFilesName(List<File> fileList) {
        List<String> fileNameList = new ArrayList<>();
        for (File file : fileList) {
            fileNameList.add(file.getName());
        }
        return fileNameList;
    }
}
