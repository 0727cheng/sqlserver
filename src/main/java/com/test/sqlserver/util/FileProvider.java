package com.test.sqlserver.util;

import com.bstek.ureport.exception.ReportException;
import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.*;

@Component
public class FileProvider implements ReportProvider, ApplicationContextAware {

    private static final String NAME = "项目服务器文件系统";
    private String fileStoreDir = "src/main/resources/ureportfiles";

    //特定前缀，ureport底层调用getPrefix方法来获报表操作的Provier类
    private String prefix = "file:";

    //是否禁用
    private boolean disable = false;


    /**
     * 加载报表方法
     *
     * @param fileName 文件名
     * @return
     */
    @Override
    public InputStream loadReport(String fileName) {
        if (fileName.startsWith(this.prefix)) {
            fileName = fileName.substring(this.prefix.length(), fileName.length());
        }

        String fullPath = this.fileStoreDir + "/" + fileName;
        try {
            return new FileInputStream(new File(fullPath));
        } catch (FileNotFoundException var4) {
            throw new ReportException(var4);
        }
    }

    /**
     * 删除文件方法
     *
     * @param fileName 文件名
     */
    @Override
    public void deleteReport(String fileName) {
        if (fileName.startsWith(this.prefix)) {
            fileName = fileName.substring(this.prefix.length(), fileName.length());
        }

        String fullPath = this.fileStoreDir + "/" + fileName;
        File f = new File(fullPath);
        if (f.exists()) {
            f.delete();
        }
    }

    /**
     * 查看文件列表
     *
     * @return
     */
    @Override
    public List<ReportFile> getReportFiles() {
        File file = new File(this.fileStoreDir);
        List<ReportFile> list = new ArrayList();
        File[] var6;
        int var5 = (var6 = file.listFiles()).length;

        for (int var4 = 0; var4 < var5; ++var4) {
            File f = var6[var4];
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(f.lastModified());
            list.add(new ReportFile(f.getName(), calendar.getTime()));
        }

        Collections.sort(list, new Comparator<ReportFile>() {
            public int compare(ReportFile f1, ReportFile f2) {
                return f2.getUpdateDate().compareTo(f1.getUpdateDate());
            }
        });
        return list;
    }

    /**
     * 保存报表方法
     *
     * @param fileName 文件名
     * @param content  存放目的地
     */
    @Override
    public void saveReport(String fileName, String content) {
        if (fileName.startsWith(this.prefix)) {     //判断文件名是否是以 prefix 定义的值为前缀
            fileName = fileName.substring(this.prefix.length(), fileName.length());
        }
        String fullPath = this.fileStoreDir + "/" + fileName;   //创建文件路径
        FileOutputStream outStream = null;  //实例文件输出流
        try {
            outStream = new FileOutputStream(new File(fullPath));   //输出文件路径，保存文件
            IOUtils.write(content, outStream, "utf-8");     //将内容写入输出流中
        } catch (Exception var13) {
            throw new ReportException(var13);
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException var12) {
                    var12.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public boolean disabled() {
        return this.disable;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        File file = new File(this.fileStoreDir);
        if (file.exists()) {
            return;
        }
        if (applicationContext instanceof WebApplicationContext) {
            WebApplicationContext context = (WebApplicationContext) applicationContext;
            ServletContext servletContext = context.getServletContext();
            String basePath = servletContext.getRealPath("/");
            this.fileStoreDir = basePath + this.fileStoreDir;
            file = new File(this.fileStoreDir);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }
}
