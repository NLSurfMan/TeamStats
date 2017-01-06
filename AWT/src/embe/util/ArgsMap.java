package embe.util;

import java.util.HashMap;
import java.util.Map;

public class ArgsMap {
    Map<String, String> argsMap;

    public ArgsMap(String[] args) {
        argsMap = new HashMap<String, String>();

        for (String arg : args) {
            argsMap.put(arg.split("=")[0], arg.split("=")[1]);
        }
    }

    public String get(String key) {
        return argsMap.get(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(argsMap.get(key));
    }

    public int getInt(String key, int defaultValue) {
        return argsMap.containsKey(key) ? Integer.parseInt(argsMap.get(key)) : defaultValue;
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(argsMap.get(key));
    }
}
