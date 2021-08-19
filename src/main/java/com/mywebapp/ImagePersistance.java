package com.mywebapp;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImagePersistance {

    private static final String FOLDER_IMAGES="/images/";

    public byte[] getImageByName(String name) throws IOException {
        File f = new File(FOLDER_IMAGES+name);

        if (!f.exists()) {
            return null;
        }

        try(FileInputStream in = new FileInputStream(f)) {
            return IOUtils.toByteArray(in);
        }
    }
}
