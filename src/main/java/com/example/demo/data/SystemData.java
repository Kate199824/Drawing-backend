package com.example.demo.data;

/**
 * 单例模式的SystemData类，保存系统配置数据
 */
public class SystemData {
    public static String BASE_ROUTE = System.getProperty("user.dir")+"/data";//跟文件夹相对于服务器的路径

    private static SystemData systemData = null;
    private SystemData(){}

    public SystemData getInstance(){
        if(systemData == null){
            systemData = new SystemData();
        }
        return systemData;
    }
}
