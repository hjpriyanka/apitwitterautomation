package API;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
public class Trends {
	
	
    Properties prop= new Properties();
    Logger L=Logger.getLogger("Trends");  
    @BeforeTest
    public void begintrends() throws IOException
    {PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\resources\\log4j.properties");
		FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\java\\API\\data.properties");
        prop.load(fls);   
    }
	@Test
	public void tweetupdate() throws IOException
	{ 
		String[] k = {"2295383","28218","23424977","23424852"};
            for(int i=0;i<4;i++)
    		{
            RestAssured.baseURI=prop.getProperty("Trends");
            Response res= given().auth().oauth( prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
		queryParam("id",k[i]).
		when().get(resource1.Trendytweet()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		
		String response=res.asString();//to convert into string
		System.out.println(response);
		L.info(response);
		
		JsonPath js=new JsonPath(response);
		String names=js.get("trends[0].name").toString();
		System.out.println("name=="+names);
		L.info(names);
	}
}
}

