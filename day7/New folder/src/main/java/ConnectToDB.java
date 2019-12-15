import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.util.Iterator;

import org.bson.Document;

public class ConnectToDB {

	public static void main(String args[]) {

		// Creating a Mongo client
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");

		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
		System.out.println("Connected to the database successfully");

		// Accessing the database
		MongoDatabase database = mongo.getDatabase("myDb");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("myCollection");
		System.out.println("Collection myCollection selected successfully");

		collection.updateOne(Filters.eq("id", 1), Updates.set("likes", 150));
		

		// Retrieving the documents after updation
		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			i++;
		}
		System.out.println("Document update successfully...");
	}
}