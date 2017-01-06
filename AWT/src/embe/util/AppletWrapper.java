package embe.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class AppletWrapper extends JFrame implements AppletStub, AppletContext {

    private final static boolean DEBUG = false;

    private Applet applet;
    private URL currDir, currBase;
    private ArgsMap argsMap;

    public static void main(String[] args) {
        Applet applet = new embe.ts.TeamStats();
        new AppletWrapper(applet, args);
    }

    public AppletWrapper(Applet applet, String[] args) {
        this.applet = applet;

        argsMap = new ArgsMap(args);

        setTitle(argsMap.get("LeagueName"));

        int width = argsMap.getInt("Width", 640);
        int height= argsMap.getInt("Height", 480);
        setSize(width, height);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        add(applet, BorderLayout.CENTER);

        applet.setStub(this);

        try {
            currDir = new URL("file:////" + System.getProperty("user.dir"));
            currBase = new URL("file:////" + System.getProperty("user.dir") + "/wrapper.html");
            if (DEBUG) {
                System.out.println("currDir=" + currDir); //   currDir=file://D:/JavaDevelopment/Testing/TeamStats_12us
                URL url = new URL(getDocumentBase(), "data/seriea97.txt");
                System.out.println("url=" + url); //  url=file://D:/JavaDevelopment/Testing/TeamStats_12us/data/seriea97.txt
            }
        }
        catch (Exception mue) {
            System.err.println(">>> malformed URL: " + System.getProperty("user.dir"));
            mue.printStackTrace();
        }


        // Trap window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                AppletWrapper.this.applet.stop();
                AppletWrapper.this.applet.destroy();
                System.exit(0);
            }
        });

        applet.init();
        setVisible(true);
        applet.start();
    }


    public boolean isActive() {
        return true;
    }

    public URL getDocumentBase() {
        return currBase;
    }

    public URL getCodeBase() {
        return currDir;
    }

    public String getParameter(String name) {
        if (DEBUG) {
            System.out.println("getParameter name=" + name);
        }
        return argsMap.get(name);
    }

    public AppletContext getAppletContext() {
        return this;
    }

    public void appletResize(int width, int height) {
    }


    // AppletContext methods - not used
    public AudioClip getAudioClip(URL url) {
        return null;
    }

    public Image getImage(URL url) {
        try {
            return ImageIO.read(url);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Applet getApplet(String name) {
        return null;
    }

    public Enumeration<Applet> getApplets() {
        return null;
    }

    public void showDocument(URL url) {
        browseToURI(url);
    }

    public void showDocument(URL url, String target) {
        browseToURI(url);
    }

    private void browseToURI(URL url) {
        if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(url.toURI());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    public void showStatus(String status) {
    }

    public Iterator<String> getStreamKeys() {
        return null;
    }

    public InputStream getStream(String key) {
        return null;
    }

    public void setStream(String key, InputStream stream) {
    }
}
