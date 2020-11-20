package com.eskdr.eskadar.data;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Voice {

    private static final int defaultWriteNum = 3;
    private static final String voiceColName = "voice";

    private final Database eskdr;

    private final MongoCollection<Document> userColl;

    public Voice() {
        eskdr = new Database();
        userColl = eskdr.connect(voiceColName);
    }

    public void close() {
        eskdr.close();
    }
}
