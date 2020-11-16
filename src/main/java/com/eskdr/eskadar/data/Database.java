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

    private MongoClient eskdrClient = null;
    private MongoDatabase eskdrDB = null;

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

    public MongoCollection<Document> connect(String connection) {
        int port = Integer.parseInt(readConnInfo(portFile));
        String host = readConnInfo(hostFile);

        eskdrClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(host, port))))
                        .build());

        eskdrDB = eskdrClient.getDatabase(DBName);

        return eskdrDB.getCollection(connection);
    }

    public boolean close() {
        if (eskdrClient != null) {
            eskdrClient.close();

            return false; // close success
        }

        return true; //no connected client
    }
}
