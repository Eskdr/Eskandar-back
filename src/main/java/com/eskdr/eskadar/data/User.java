package com.eskdr.eskadar.data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class User {

    private static int defaultWriteNum = 3;
    private static String userColName = "user";
    private Database eskdr = null;
    private MongoCollection<Document> userColl;

    public User() {
        eskdr = new Database();

        userColl = eskdr.connect(userColName);
    }

    public int login(String id) {
        MongoCursor<Document> cursor = null;
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
        Document doc = new Document();

        doc.put(id, defaultWriteNum);
        userColl.insertOne(doc);

        return defaultWriteNum; // sign-up success
    }

    public boolean close() {
        return eskdr.close(); // db close result
    }
}
