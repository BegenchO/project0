package project0

import org.mongodb.scala._
import scala.io.Source
import project0.Helpers._

object Main {

    def main(args: Array[String]) {

        // Connect to mongoDB server and get collection
        val client: MongoClient = MongoClient()

        val collection: MongoCollection[Document] = client.getDatabase("project0").getCollection("users")

        // Read JSON file
        val stringDocuments = Source.fromFile("C:/data.json").getLines.toList

        // Convert JSON Strings to mongoDB Document type
        val bsonDocuments = stringDocuments.map(doc => Document(doc))

        // Save documents to local mongoDB 
        collection.insertMany(bsonDocuments).printResults()

        client.close()



    } // end main

} // end Main