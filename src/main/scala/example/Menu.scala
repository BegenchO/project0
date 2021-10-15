package example

import org.mongodb.scala._

import scala.io.Source

import example.Helpers._


object Menu {  
    def main(args: Array[String]) {

        // println("Welcome to the project 0")
        // println("Connecting to mongoDB...")

        // Connect to local mongoDB server
        val client: MongoClient = MongoClient()
        //val client = MongoClient("mongodb://host1:27017")

        // Get DB
        val database: MongoDatabase = client.getDatabase("test")
       
        // Get Collection
        val collection: MongoCollection[Document] = database.getCollection("users")
    

       val documents = Source.fromFile("C:/data.json").getLines.toList
       // println(documents)

       val bsonDocuments = documents.map(document => Document(document))

        collection.insertMany(bsonDocuments).printResults()
      
       // close DB
        println("Closing connection...")
        
        client.close()

        println("Connection closed")

    

    } // end main


    def convertStringToDocument(stringDocuments: List[String]): Unit = {
        
        stringDocuments.foreach(stringDocument => {
            var doc = stringDocument

            
            
        })
      
        
       
    }
} // end object