package nl.wveldhuis.ts.ui.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class TextResources {
    private static ResourceBundle bundle = ResourceBundle.getBundle("nl.wveldhuis.ts.resources.Captions");

    public static String get(String key) {
        return bundle.getString(key);
    }

    public static String get(String key, String... args) {
        String string = bundle.getString(key);
        return MessageFormat.format(string, (Object[]) args);
    }

}
