package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DiabloGames {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String path = DiabloGames.class.getClassLoader().getResource("demo/jdbc.properties").getPath();

        try {
            properties.load(new FileInputStream(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
