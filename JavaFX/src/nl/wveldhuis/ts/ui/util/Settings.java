package nl.wveldhuis.ts.ui.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Properties;

public class Settings {
    public static final String LAST_TEAMSTATS_FILE = "last_teamstats_file";

    private Properties props;

    public Settings() {
        props = new Properties();
        load();
    }

    public void set(String key, String value) {
        props.put(key, value);
    }

    public String get(String key) {
        return Objects.toString(props.get(key), null);
    }

    public void load() {
        try {
            props.loadFromXML(Files.newInputStream(Paths.get(System.getProperty("user.dir"), "teamstats.xml")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            props.storeToXML(Files.newOutputStream(Paths.get(System.getProperty("user.dir"), "teamstats.xml")),
                             "Settings saved on " + LocalDateTime.now().toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
