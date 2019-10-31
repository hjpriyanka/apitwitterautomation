package API;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;

public class postapis{
Properties prop= new Properties();
Logger L=Logger.getLogger("postapis");   

@BeforeTest
    public void beginpost() throws IOException
    {
	PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\resources\\log4j.properties");
    	FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\java\\API\\data.properties");
        prop.load(fls);
    }
    @Test
    public void postTweet() throws Exception {
  
        RestAssured.baseURI=prop.getProperty("statuses");
        Response res= given().auth().oauth( prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
                queryParam("status", "I am learning API testing , #Qualitest").
                when().post(resource1.postResource()).
                then().extract().response();
        String response= res.asString();
        System.out.println("created=="+response);
        L.info(response);
        JsonPath js= new JsonPath(response);
        
        String text= js.get("text").toString();
        System.out.println(text);
        L.info(text);
        
        String id= js.get("id").toString();
        System.out.println(id);
        L.info(id);
        
        //delete the tweet
        Response re= given().auth().oauth( prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
        when().post("/destroy/"+id+".json").
        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
        String response1= re.asString();
        System.out.println("deleted=="+response1);
        L.info(response1);
    }


}






