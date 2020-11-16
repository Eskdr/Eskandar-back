package com.eskdr.eskadar.data;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Voice {

    private static final int defaultWriteNum = 3;
    private static final String voiceColName = "voice";
    private final MongoCollection<Document> userColl;

    private Database eskdr = null;

    public Voice() {
        eskdr = new Database();
        userColl = eskdr.connect(voiceColName);
    }

    public boolean close() {
        return eskdr.close();
    }
}
