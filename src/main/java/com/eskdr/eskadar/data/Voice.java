package com.eskdr.eskadar.data;

import com.mongodb.client.MongoCollection;
import org.apache.tomcat.jni.FileInfo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

public class Voice {

    private static final int defaultWriteNum = 3;
    private static final String voiceColName = "voice";

    private final Database eskdr = null;

    private MongoCollection<Document> voiceCollection = null;

    public Voice() {
        this.voiceCollection = Database.getDatabase().getVoiceCollection();
    }
}
