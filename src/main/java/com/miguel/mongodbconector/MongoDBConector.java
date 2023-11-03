
package com.miguel.mongodbconector;

import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
/**
 *
 * @ MIGUEL ACOSTA
 */
public class MongoDBConector {
    
    private String uri ="mongodb://localhost:27017";
    MongoClient mongoClient = MongoClients.create(uri);
    public static void main(String[] args) {
        
      MongoDBConector mongoClient = new MongoDBConector();
      
      // ImprimirLista(mongoClient.MonstrarDbs());
      
      
      MongoDatabase db = findDataBase("local");
      newColection(db, "personas");
      
      insertarPersona(db,"personas",new Persona("Ramon", "Garcia"));
      
      
      
    }
 
    public MongoIterable<String> MonstrarDbs(){
         
        return mongoClient.listDatabaseNames();
    }
    static void ImprimirLista(MongoIterable<String> lista){
        
    for(String s:lista){
            System.out.println("ListaBaseDatos = " + s);
            
        }
    }
    
    public static void newColection(MongoDatabase database, String dbName){
        
        database.createCollection(dbName);
        
        System.out.println("nueva coleccion creada: " + dbName);
        
    }
    
    public static void insertarPersona(MongoDatabase database, String dbName, Persona persona){
    
    MongoCollection<Document> collection = database.getCollection(dbName);
       
    Document document = new Document("Persona", persona.getNombre())
                .append("apellido", persona.getNombre());
                
    collection.insertOne(document);
    MongoCursor<Document> cursor = collection.find().iterator();

        while (cursor.hasNext()) {
            Document cursorDocument = cursor.next();
            System.out.println(cursorDocument.toJson());
        }
    }
    
    public static MongoDatabase findDataBase(String DatabaseName){
       
        String connectionString = "mongodb://localhost:27017";
      
        MongoClient mongoClient = MongoClients.create(connectionString);
       
        MongoDatabase database = mongoClient.getDatabase(DatabaseName);
        
      return database;
    }
    
     

      
}
