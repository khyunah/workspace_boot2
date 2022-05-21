package ch05.kha;

import java.util.ArrayList;

public class MovieDto {
	String status;
	String status_message;
	Data data;
	
	@Override
	public String toString() {
		return "MovieDto [status=" + status + ", status_message=" + status_message + ", data=" + data + "]";
	}
	
}

class Data {
	int movie_message;
	int limit;
	int page_number;
	ArrayList<Movies> movies = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Data [movie_message=" + movie_message + ", limit=" + limit + ", page_number=" + page_number
				+ ", movies=" + movies + "]";
	}
	
}

class Movies {
	int id;
	String url;
	String imdb_code;
	String title;
	String title_english;
	String title_long;
	String slug;
	int year;
	float rating;
	int runtime;
	ArrayList<String> genres = new ArrayList<> ();
	String summary;
	String description_full;
	String synopsis;
	String yt_trailer_code;
	String language;
	String mpa_rating;
	String background_image;
	String background_image_original;
	String small_cover_image;
	String medium_cover_image;
	String large_cover_image;
	String state;
	
	@Override
	public String toString() {
		return "Movies [id=" + id + ", url=" + url + ", imdb_code=" + imdb_code + ", title=" + title
				+ ", title_english=" + title_english + ", title_long=" + title_long + ", slug=" + slug + ", year="
				+ year + ", rating=" + rating + ", runtime=" + runtime + ", genres=" + genres + ", summary=" + summary
				+ ", description_full=" + description_full + ", synopsis=" + synopsis + ", yt_trailer_code="
				+ yt_trailer_code + ", language=" + language + ", mpa_rating=" + mpa_rating + ", background_image="
				+ background_image + ", background_image_original=" + background_image_original + ", small_cover_image="
				+ small_cover_image + ", medium_cover_image=" + medium_cover_image + ", large_cover_image="
				+ large_cover_image + ", state=" + state + "]";
	}
	
}
