package API;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
public class blockuSER
{
	public static Logger L=Logger.getLogger("blockuSER");

    String Consumerkey = "lCiPRO4nEK6xi2joi0uW30RSV";
    String ConsumerSecretkey = "UP3FMMuahNYD3sJ7sAdPvu4LfKcwWOSpZDNEmJ8CT9K1uTIxZQ";
    String Token = "852810423300521984-hjWUsf104UJB9FKgtPsl50aZNqTpY64";
    String TokenSecretkey = "HTJNcSkZWp8hlFueDlKDyH1ZyVfrJyImyQw7KnP8AKpXK";
    
    @Test
    public void Blockuser()
    {
    	PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\resources\\log4j.properties");
         RestAssured.baseURI="https://api.twitter.com/1.1";
         Response res=given().auth().oauth(Consumerkey, ConsumerSecretkey, Token, TokenSecretkey).
            queryParam("screen_name", "hj_priyanka").
            when().post("/blocks/create.json").then().extract().response();
            String responce=res.asString();
            L.info(responce);
            System.out.println("block="+responce);
            L.info(responce);
            JsonPath js=new JsonPath(responce);
            String id=js.get("name").toString();
            System.out.println(id);
           L.info(id);
            
            Response res1=given().auth().oauth(Consumerkey, ConsumerSecretkey, Token, TokenSecretkey).
            queryParam("screen_name", "hj_priyanka").
            when().post("/blocks/destroy.json").then().extract().response();
            String responce1=res1.asString();
            L.info(responce1);
            L.info("******Block user****");
            System.out.println("unblocked="+responce1);
           
            JsonPath js1=new JsonPath(responce1);
            String id1=js1.get("name").toString();
            System.out.println(id1);
           L.info(id1);
            
    }
}
 





