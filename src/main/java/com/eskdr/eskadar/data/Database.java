package com.eskdr.eskadar.data;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.*;
import java.util.Arrays;

public class Database {

    private static final String DBName = "eskdr";
    private static final String portFile = "port.txt"; // todo(@hw : yaml에서 설정 가져오기)
    private static final String hostFile = "host.txt";
    private static final String userCollectionName = "user";
    private static final String voiceCollectionName = "voice";

    private static MongoClient eskdrClient = null;
    private static MongoCollection<Document> userCollection = null;
    private static MongoCollection<Document> voiceCollection = null;
    private MongoDatabase eskdrDB = null;

    private Database() {
        connect();
    }

    public static Database getDatabase() {
        return databaseInstance.instance;
    }

    public static void close() {
        if (eskdrClient != null)
            eskdrClient.close();
    }

    private String readConnInfo(String filename) {
        String line = null;

        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(fileReader);

            line = bufReader.readLine();

            bufReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    private void connect() {
        int port = Integer.parseInt(readConnInfo(portFile));
        String host = readConnInfo(hostFile);

        eskdrClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(host, port))))
                        .build());

        eskdrDB = eskdrClient.getDatabase(DBName);

        userCollection = eskdrDB.getCollection(userCollectionName);
        voiceCollection = eskdrDB.getCollection(voiceCollectionName);
    }

    public MongoCollection<Document> getUserCollection() {
        return userCollection;
    }

    public MongoCollection<Document> getVoiceCollection() {
        return voiceCollection;
    }

    private static class databaseInstance {
        private static final Database instance = new Database();
    }
}
