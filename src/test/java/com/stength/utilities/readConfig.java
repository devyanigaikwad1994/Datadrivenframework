package com.stength.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
    Properties pro;

    public readConfig()
    {
File src= new File("./Configuration/config.properties");
        try
        {
            FileInputStream file= new FileInputStream(src);
        pro=  new Properties();
        pro.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getApplication()
    {
        String url= pro.getProperty("baseUrl");
        return url;
    }

    public String getUname()
    {
        String name=pro.getProperty("uname");
    return name;
    }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }

    public String getDriver()
    {
        String chromeDriver=pro.getProperty("chromepath");
        return chromeDriver;
    }
}
