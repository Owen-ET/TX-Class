package com.testZC.wework;

/**
 * @author zc
 * @date 2019-04-30 14:46
 */

public class WewordConfig {

    public String agentId = "1000002";
    public String secret = "H5j8MaSLA1S8duEKEy2VStFpwAmOxqfcbuYXNfTK9Vc";
    public String corpid = "ww2c06edca9d5e15ff";
    public String 通讯录Secret = "Z54tfGsdmgZfrBz09NH1WpK8VvC-VlvHD-SDAlfKXQg";
    public String id = "2";

    //单例模式
    private static WewordConfig wewordConfig;
    public static WewordConfig getInstance(){
        if(wewordConfig==null){
            wewordConfig=new WewordConfig();
        }
        return wewordConfig;
    }

    // 配置文件
    public static void load(String path){
        //todo:read from yaml or json

    }
}
