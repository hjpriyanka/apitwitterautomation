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
import java.util.logging.Logger;
public class TWeet {
	Properties prop= new Properties();
	Logger L=Logger.getLogger("TWeet"); 
	@BeforeTest
	public void begintweet() throws IOException
	{PropertyConfigurator.configure("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\resources\\log4j.properties");
		FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\Desktop\\swapnil\\apiautomation\\src\\main\\java\\API\\data.properties");
        prop.load(fls);
	}
	@Test
	public void creatapis() throws IOException {
		
        RestAssured.baseURI=prop.getProperty("statuses");
        Response res= given().auth().oauth( prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).

when().get(resource1.TWeets()).
then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
String response=res.asString();
System.out.println(response);
L.info(response);
JsonPath js=new JsonPath(response);
String id=js.get("id").toString();
System.out.println(id);
L.info(id);
String text=js.get("text").toString();
System.out.println(text);
L.info(text);
	}
}
