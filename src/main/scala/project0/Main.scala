package project0

import org.mongodb.scala._
import scala.io.Source
import project0.Helpers._

object Main {

    def main(args: Array[String]) {

        println("----------------------------------------------------")
        println("Connecting to MongoDB...")

        // Connect to mongoDB server and get collection
        val client: MongoClient = MongoClient()

        println("----------------------------------------------------")
        println("Connection success! Fetching collection from the database...")

        val collection: MongoCollection[Document] = client.getDatabase("project0").getCollection("users")

        println("----------------------------------------------------")
        println("Collection retrieved successfully! Reading JSON file...")

        // Read JSON file
        val stringDocuments = Source.fromFile("C:/data.json").getLines.toList

        println("----------------------------------------------------")
        println("File read success! Preparing Documents to insert into MongoDB...")

        // Convert JSON Strings to mongoDB Document type
        val bsonDocuments = stringDocuments.map(doc => Document(doc))

        println("----------------------------------------------------")
        println("Documents ready! Inserting into the database...")

        // Save documents to local mongoDB and print message
        try {
            println(collection.insertMany(bsonDocuments).headResult())
        } catch {
            case _: Throwable => println("ERROR: Was NOT able to save documents into the database. Please try again!")
        }
        
        println("----------------------------------------------------")
        println("Closing connection...")

        client.close()

        println("----------------------------------------------------")
        println("Connection closed. Please exit sbt and start mongo shell.")


    } // end main

} // end Main