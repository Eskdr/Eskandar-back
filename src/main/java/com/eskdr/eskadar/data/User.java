package com.eskdr.eskadar.data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class User {

    private static final int defaultWriteNum = 3;
    private static final String userColName = "user";

    private final Database eskdr;
    private final MongoCollection<Document> userColl;

    public User() {
        eskdr = new Database();

        userColl = eskdr.connect(userColName);
    }

    public int login(String id) {
        MongoCursor<Document> cursor;
        Document document = new Document();

        document.get(id);
        cursor = userColl.find(document).iterator();

        while (cursor.hasNext()) {
            Object writeNum = cursor.next().get(id);
            if (writeNum != null) {
                return (int) writeNum;
            }
        }

        return signUp(id);
    }

    private int signUp(String id) {
        Document document = new Document();

        document.put(id, defaultWriteNum);
        userColl.insertOne(document);

        return defaultWriteNum;
    }

    public void close() {
        eskdr.close();
    }
}
