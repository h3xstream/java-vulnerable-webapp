package com.mywebapp;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

public class MyControllerFacade {

    @Inject
    ImagePersistance imgPersist;

    public byte[] getImageThumbnail(String image,boolean isCache) {

        if(isCache) {
            try {
                return imgPersist.getImageByName(image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            return new byte[]{};
        }
    }
}
