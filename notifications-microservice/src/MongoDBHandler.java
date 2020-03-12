import java.util.Arrays;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBHandler {
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	public MongoDBHandler() {
		establishConnection();
		setDatabase("SENG401");
	}
	
	public void addNotification(MyNotification notification) {
		Document toInsert = new Document();
		toInsert.put("User ID", notification.getUser_id());
		toInsert.put("Forum ID", notification.getForum_id());
		toInsert.put("Timestamp", notification.getTime());
		toInsert.put("Seen", notification.getSeenFlag());
		toInsert.put("Message", notification.getMessage());
		
		//should be able to get the collection here and attempt an insert
		setCollection("Notifications");
		collection.insertOne(toInsert);
	}
	
	public void deleteNotification() {
		Document toDelete = new Document();
		toDelete.put("Seen", "True");
		
		setCollection("Notifications");
		collection.deleteOne(toDelete);
	}
	
	public void getAllNotifications(String key, String value) {
		setCollection("Notifications");
		
		Document query = new Document();
		query.put(key, value);
		FindIterable<Document> cursor = collection.find(query);
		MongoCursor<Document> iterator = cursor.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void getOneNotification(String key, String value) {
		setCollection("Notifications");
		
		Document query = new Document();
		query.put(key, value);
		FindIterable<Document> cursor = collection.find(query);

		System.out.println(cursor.first());

	}
	
	private void establishConnection() {	//this might break later have yet to test
		mongoClient = MongoClients.create(
				"mongodb+srv://SENG401:seng401@cluster0-hcvzz.mongodb.net/test?retryWrites=true&w=majority");
		database = mongoClient.getDatabase("test");		
	}
	
	private void setDatabase(String db_name) {
		database = mongoClient.getDatabase(db_name);
	}
	
	private void setCollection(String name) {
		collection = database.getCollection(name);
	}
	
	private void closeConnection() {
		mongoClient.close();
	}
}
