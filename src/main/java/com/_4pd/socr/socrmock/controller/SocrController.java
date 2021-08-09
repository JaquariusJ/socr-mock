package com._4pd.socr.socrmock.controller;

import com._4pd.socr.socrmock.vo.SocrRequestVo;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/predict")
public class SocrController {

    private static Map<String,String> scene_file_map = new HashMap<>();

    static{
        scene_file_map.put("idcard","/Users/wujian/IdeaProjects/socr-mock/src/main/resources/static/IDCard.json");
        scene_file_map.put("BusinessLicense","/Users/wujian/IdeaProjects/socr-mock/src/main/resources/static/Business.json");
        scene_file_map.put("spinvoice","/Users/wujian/IdeaProjects/socr-mock/src/main/resources/static/VAT.json");
    }

    @PostMapping("/ticket")
    public String ocr(@RequestBody SocrRequestVo requestVo) throws IOException {
        System.out.println(requestVo);
        String scene = requestVo.getScene();
        String file = scene_file_map.get(scene);
        char[] char_array = new char[1024];
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(new File(file));
        int length = 0;
        while((length = reader.read(char_array)) !=-1){
            sb.append(new String(char_array,0,length));
        }
        return sb.toString();
    }


}
