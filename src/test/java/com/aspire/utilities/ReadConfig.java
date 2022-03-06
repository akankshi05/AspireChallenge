package com.aspire.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
        File src = new File("src/test/Configurations/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("The exception in loading properties file is: " + e);
        }
    }

    public String getApplicationURL() {
        return prop.getProperty("URL");
    }

    public String getUserName() {
        return prop.getProperty("userName");
    }

    public String getPassword() {
        return prop.getProperty("passWord");
    }

}
