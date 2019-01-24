package driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

/**
 * @author zc
 * @date 2019-01-24 11:40
 */

public class GlobalConfig {
    // 全局化的配置
    public AppiumConfig appium = new AppiumConfig();
    public XueqiuConfig xueqiu = new XueqiuConfig();



    static GlobalConfig load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            // 从一个特定的路径path下，读取yaml文件
            GlobalConfig config = mapper.readValue(GlobalConfig.class.getResource(path), GlobalConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
