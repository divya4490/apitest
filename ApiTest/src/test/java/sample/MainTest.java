package sample;

import sample.MovieDBTest.*;

public class MainTest {
	
	final static String api_key = "47673d98e3a90c9cff4a9d79145366e4";
	final static String url_get_latest = "https://api.themoviedb.org/3/movie/latest";
	final static String url_rate_movie = "https://api.themoviedb.org";


	public static void main(String args[]) {
		MovieDBTest md = new MovieDBTest();
		
		//getLatest Positive scenarios test
		md.verifyURLUpGetLatest(api_key, url_get_latest);
		md.responseTimeGoodGetLatest(api_key, url_get_latest);
		
		//getLatest Negative Scenarios Test
		md.verifyURLDownGetLatest(api_key, url_get_latest);
		md.responseTimeDelayedGetLatest(api_key, url_get_latest);
		//md.allValidValuesRateMovie(api_key, url_rate_movie, 550, "application/json", 7.6f);
	}
	


}
