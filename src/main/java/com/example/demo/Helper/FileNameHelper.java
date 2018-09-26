package com.example.demo.Helper;

import com.example.demo.data.SystemData;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class FileNameHelper {

    public String getFileName(String userRoute, String userFilename){
        String result = userFilename;
        //用户文件夹是否存在
        File file = new File(SystemData.BASE_ROUTE+"/"+userRoute);
        if(!file.exists()){
            file.mkdirs();
        }

        File[] files = file.listFiles();
        int count = 0;
        for(File f : files){
            if(f.getName().length()>=userFilename.length() && (f.getName().substring(0,userFilename.length())).equals(userFilename)){
                count++;
            }
        }
        if(count>0){
            result = result+count;
        }
        return result;
    }

    public ArrayList<String> allProjects(String userRoute){
        ArrayList<String> res = new ArrayList<String>();
        File file = new File(SystemData.BASE_ROUTE+"/"+userRoute);
        if(!file.exists()){
            file.mkdirs();
        }
        File[] files = file.listFiles();
        for(File f : files){
            if(!f.getName().equals(".DS_Store")){
                res.add(f.getName());
                System.out.println(f.getName());
            }
        }
        return res;
    }

    public void deleteProject(String userRoute, String userFilename) {
        //用户文件夹是否存在
        File file = new File(SystemData.BASE_ROUTE+"/"+userRoute);
        if(!file.exists()){
            file.mkdirs();
        }

        File[] files = file.listFiles();
        for(File f : files){
            if(f.getName().equals(userFilename)){
                File[] subFiles = f.listFiles();
                for(File sf : subFiles){
                    System.out.println("DELETE: "+sf.getName());
                    sf.delete();
                }
                f.delete();
            }
        }
    }
}
