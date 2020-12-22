package com.eskdr.eskadar.data;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class User {

    private static final int defaultWriteNum = 3;

    private final MongoCollection<Document> userCollection;

    public User() {
        this.userCollection = Database.getDatabase().getUserCollection();
    }


    public int login(String id) {
        MongoCursor<Document> cursor;
        Document userInformation = new Document();

        userInformation.get(id);
        cursor = this.userCollection.find(userInformation).iterator();

        while (cursor.hasNext()) {
            Object writeNum = cursor.next().get(id);
            if (writeNum != null) {
                return (int) writeNum;
            }
        }

        return signUp(id);
    }

    private int signUp(String id) {
        Document userInformation = new Document();

        userInformation.put(id, defaultWriteNum);
        userCollection.insertOne(userInformation);

        return defaultWriteNum;
    }
}
