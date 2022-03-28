package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties prop = new Properties();

    public static void initProperties(){

        try {
            prop.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            System.out.println("Exception found at: "+ e.toString());
        }

    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }


}
