package API;

public class resource1 {

	    //postapis
	    public static String postResource() {
	        String res= "/update.json";
	        return res;
	    }
	    
	    //searchtweet,listofusers,weather
	    public static String Resourceretweet() {
	        String res= "/tweets.json";
	        return res;
	    }
	    
	    //Trends
	    public static String Trendytweet() {
	        String res= "/trends/place.json";
	        return res;
	    }
	    
	    //tweet
	    public static String TWeets() {
	        String res= "/user_timeline.json";
	        return res;
	    }
}

