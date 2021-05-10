/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProGApp;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import java.time.LocalDate;
import java.util.Collection;
import org.json.JSONObject;
/**
 *
 * @author DUONG.BuiQuang
 */
public class Connection {
  
  public static MongoDatabase getConnectionDB (String db) {
    String uri = "mongodb+srv://" + Constants.DB_USERNAME + ":" + Constants.DB_PASSWORD + "@cluster0.vjrei.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uri);
    MongoDatabase database = mongoClient.getDatabase(db);
    return database;
  } 
  
  public static MongoCollection getCollection (String db, String collection) {
    return getConnectionDB(db).getCollection(collection);
  }
  
  public static JSONObject checkAccount(String username, String password) {
    var users = getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_USER);
    Document user = (Document) users.find(and(eq("username", username), eq("password", password))).first();
    JSONObject payload = new JSONObject();
    if(user != null) {
      payload.put("username", user.get("username"));
      payload.put("_id", user.get("id"));
      payload.put("todoId", user.get("todoId"));
      return payload;
    }
    return null;
  }
     
  public static ArrayList getMyTodos(int id) {
    var data = getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_TODO);
    ArrayList <Document> todos = new ArrayList<>();
    data.find(and(eq("user_id", id), eq("created_at", LocalDate.now()), eq("is_finished", false))).forEach(d -> todos.add((Document) d));
    System.out.println(todos);
    ArrayList <String> works = new ArrayList<>();
    todos.forEach(t -> works.add((String) t.get("todo_work")));
    return works;
  }
  
  public static ArrayList getMyDoneTodos(int id) {
     var data = getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_TODO);
    ArrayList <Document> todos = new ArrayList<>();
    data.find(and(eq("user_id", id), eq("created_at", LocalDate.now()), eq("is_finished", true))).forEach(d -> todos.add((Document) d));
    System.out.println(todos);
    ArrayList <String> works = new ArrayList<>();
    todos.forEach(t -> works.add((String) t.get("todo_work")));
    return works;
  }
  
  public static void addTodo(Document doc) {
    getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_TODO).insertOne(doc);
  }
  
  public static void deleteTodo(String work) {
    getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_TODO).deleteOne(eq("todo_work", work));
  }
  
  public static void updateTodo(String preValue, String content) {
    getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_TODO).updateOne(eq("todo_work", preValue), combine(set("todo_work", content)));
  }
  
  public static boolean createAccount(String username, String password) {
    var userCollection = getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_USER);
    var count = userCollection.countDocuments();
    var user = userCollection.find(eq("username", username)).first();
    if(user == null) {
      userCollection.insertOne(new Document("username", username).append("password", password).append("todoId", count+1));
      return true;
    }
    return false;
  }
  
  public static void updateFinishTask(String work) {
    getCollection(Constants.DB_DATABASE, Constants.DB_COLLECTION_TODO).updateOne(eq("todo_work", work), combine(set("is_finished", true)));
  }
}