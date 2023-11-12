package utilites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Global {
    private static final Properties properties = new Properties();

    public static void setProperty(String key, String value) {

        loadProperties();
        properties.put(key, value);
    }

    private static void loadProperties() {
        if (properties.size() == 0) {
            InputStream input = null;

            try {


                input = Global.class.getResourceAsStream("/web.properties");

                // load a properties file
                properties.load(input);

                // get the property value and print it out
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String value) {
        loadProperties();
        // System.out.println(properties.getProperty(value));
        return properties.getProperty(value);

    }
}
