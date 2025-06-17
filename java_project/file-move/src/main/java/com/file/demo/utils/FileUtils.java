package com.file.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.file.demo.model.FileSourceResponse;

public class FileUtils {

    /**
     * Method of getting source file config property value.
     * Property name needed for the config file: file.source.dir
     *
     * @param path
     * @return file property value
     * @throws IOException
     */
    public FileSourceResponse getFileDirectory(String path) throws IOException {
        InputStream input = new FileInputStream(path);

        Properties prop = new Properties();
        prop.load(input);

        return new FileSourceResponse(prop.getProperty("file.source.dir"), prop.getProperty("file.destination.dir"));
    }
}
