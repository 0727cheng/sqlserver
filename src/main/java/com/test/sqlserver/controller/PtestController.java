package com.test.sqlserver.controller;

import com.test.sqlserver.service.PtestService;
import com.test.sqlserver.util.FileListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.*;

@Controller
//@RequestMapping("/test")
public class PtestController {

    @Autowired
    PtestService ptestService;

    @RequestMapping("/index")
    public String index() {
        return "Ptest";
    }

    @RequestMapping("/")
    public String ureport2(Model model){
        FileListUtil util = new FileListUtil();
        List<File> fileList = new ArrayList<>();
        String path = "src/main/resources/ureportfiles";

        List<String> fileNames = util.getFilesName(util.getFiles(fileList,path));
        model.addAttribute("fileNames",fileNames);
        return "TreeIndex";
    }

//    @RequestMapping("/delete")
//    public void delete(@RequestParam("file") String file){
//        String fullPath =  "src/main/resources/ureportfiles/" + file;
//        File f = new File(fullPath);
//        if (f.exists()) {
//            f.delete();
//        }
//    }



    @RequestMapping("/query")
    @ResponseBody
    public List<String> query() {
        List<String> list = new ArrayList<>();
        String shui = ptestService.queryShui();
        String lu = ptestService.queryLu();
        String wen = ptestService.queryWen();
        list.add(shui);
        list.add(lu);
        list.add(wen);
        return list;
    }

    @RequestMapping("/queryLike")
    @ResponseBody
    public List<List<String>> queryLike() {
        List<List<String>> list = new ArrayList<>();
        List<String> shui = new ArrayList<>();
        List<String> lu = new ArrayList<>();
        List<String> wen = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            shui.add(ptestService.queryShuiLike("2019-0" + i));
            lu.add(ptestService.queryLuLike("2019-0" + i));
            wen.add(ptestService.queryWenLike("2019-0" + i));
        }
        for (int i = 10; i <= 12; i++) {
            shui.add(ptestService.queryShuiLike("2019-" + i));
            lu.add(ptestService.queryLuLike("2019-" + i));
            wen.add(ptestService.queryWenLike("2019-" + i));
        }
        list.add(shui);
        list.add(lu);
        list.add(wen);

        return list;
    }

    @RequestMapping("/queryShuiKind")
    @ResponseBody
    public Map<String,Object> queryShuiKind(){
        Map<String,Object> map = new HashMap<>();
        Set<String> kingName = ptestService.queryShuiKindName();
        for (String str: kingName) {
            map.put(str,ptestService.queryShuiKindLike(str));
        }
        return map;
    }

    @RequestMapping("/queryLuKind")
    @ResponseBody
    public Map<String,Object> queryLuKind(){
        Map<String,Object> map = new HashMap<>();
        Set<String> kingName = ptestService.queryLuKindName();
        for (String str: kingName) {
            map.put(str,ptestService.queryLuKindLike(str));
        }
        return map;
    }

    @RequestMapping("/queryWenKind")
    @ResponseBody
    public Map<String,Object> queryWenKind(){
        Map<String,Object> map = new HashMap<>();
        Set<String> kingName = ptestService.queryWenKindName();
        for (String str: kingName) {
            if (str==null){
                continue;
            }
            map.put(str.trim(),ptestService.queryWenKindLike(str.trim()));
        }
        return map;
    }



}
