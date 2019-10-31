package API;
import static io.restassured.RestAssured.given;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Searchtweet{
	Properties prop= new Properties();
	Logger L=Logger.getLogger("Searchtweet"); 
	@BeforeTest
	public void searchbegin() throws IOException
	{PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\resources\\log4j.properties");
		FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\java\\API\\data.properties");
        prop.load(fls);
       
	}
	@Test
	public void searchtweet() throws IOException
	{ RestAssured.baseURI=prop.getProperty("Search");
        Response res= given().auth().oauth( prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
		
		queryParam("q","#Qualitest").
		when().get(resource1.Resourceretweet()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		
		
		String response=res.asString();//to convert into string
		System.out.println(response);
		L.info(response);
	
}
}
