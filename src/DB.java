import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class DB {

    private String userId;
    private boolean tText = false;
    private String rText;
    private Scanner scanner = new Scanner(System.in);
    private String transText;

    private AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://dynamodb.us-east-1.amazonaws.com", "us-east-1"))
                .build();

    private DynamoDB dynamoDB = new DynamoDB(client);

    private Table table = dynamoDB.getTable("translate");


    public void addItems(String userId,String rText,String transText,Boolean isTextTranslated) {
        try {
            System.out.println("Added New item....");
            PutItemOutcome outcome = table
                    .putItem(new Item().withPrimaryKey("userID", userId)
                            .withString("rText", rText)
                            .withBoolean("tText", isTextTranslated)
                            .withString("translated",transText));

            System.out.println("PutItem succeeded:\n" + outcome.toString());
        } catch (Exception e) {
            System.err.println("Unable to add item: " + userId);
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> loadTable(){
        ScanSpec scanSpec = new ScanSpec()
                .withProjectionExpression("userID,tText,rText,translated");

        ArrayList<String> details = new ArrayList<String>();

        try{
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);

            Iterator<Item> iter = items.iterator();
            while(iter.hasNext()){
                Item item = iter.next();
                details.add(item.getString("userID"));
                details.add(String.valueOf(item.getBoolean("tText")));
                details.add(item.getString("rText"));
                details.add(item.getString("translated"));

            }
        }catch (Exception e){
            System.out.println("Cannot load table");
            System.out.println(e.getMessage());
        }

        return details;

    }
}
