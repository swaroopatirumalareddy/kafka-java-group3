package edu.nwmissouri.bigdata.sindhurani;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ProducerBySindhuRaniGoli{
	 private static Scanner in;

	  public static void main(String[] argv) throws Exception {
	    if (argv.length != 1) {
	      System.err.println("Please specify 1 parameter (the name of the topic)");
	      System.exit(-1);
	    }
	    String topicName = argv[0];
	    in = new Scanner(System.in);
	    System.out.println("Thank you for providing the topic " + topicName + "\n");
	    System.out.println("Enter message (type exit to quit).\n");

	    // Configure the Producer
	    Properties configProperties = new Properties();
	    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	        "org.apache.kafka.common.serialization.ByteArraySerializer");
	    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	        "org.apache.kafka.common.serialization.StringSerializer");
	    System.out.println("The configuration properties are: " + configProperties.toString());
	    System.out.println("\nWill use this configuration to create a producer.\n");

	    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

	   
	    
	      String message = removeSpaces();
	      ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
	      producer.send(record);
	   
	    
	    // still allow input from keyboard
		String line = in.nextLine();
	    while (!line.equals("exit")) {
	      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
	      producer.send(rec);
	      line = in.nextLine();
	    }

	    in.close();
	    producer.close();

	  }
	  
	  private static String removeSpaces(){
        String str1="i am sindhu rani goli, pursuing masters at N W M M S U";    
            
        //Removes the white spaces using regex    
        str1 = str1.replaceAll("\\s+", "");    
            
         
	      
	      
	      return "String after removing all the white spaces : " + str1;
	  }
}