package utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class DeviceFarmUtility {
    private static DesiredCapabilities desiredCapabilities = null;
    public static DesiredCapabilities pathDesiredCapabilities(String path){
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, ?>>(){}.getType();
            Map<String , ?> map =  gson.fromJson(new FileReader(path), type);
            desiredCapabilities = new DesiredCapabilities(map);
            return desiredCapabilities;
        } catch (Exception e) {
            System.out.println(e);
        }
        return desiredCapabilities;
    }
}
