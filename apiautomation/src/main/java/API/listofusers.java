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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class listofusers 
{
	
Properties prop= new Properties();
Logger L=Logger.getLogger("listofusers");

@BeforeTest
public void begin() throws IOException {
	PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\resources\\log4j.properties");
FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\java\\API\\data.properties");
prop.load(fls);
}
	
	@Test
	public void listusers() throws IOException 
	{PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\TwitterApi\\src\\data.properties");
	    RestAssured.baseURI=prop.getProperty("Search");
	    Response res= given().auth().oauth( prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
	    param("q","Qualitest").
	    when().get(resource1.Resourceretweet()).
	    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		String response=res.asString();
		L.info(response);
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		int count=js.get("statuses.size()");
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String user=js.get("statuses["+i+"].user.screen_name");
			System.out.println("User name == "+user);
			L.info(user);
		}
	}
}
