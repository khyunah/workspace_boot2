package dto;

import java.util.ArrayList;

import lombok.Data;
/**
 * https://yts.mx/api/v2/list_movies.json<br>
 * 파싱하는거 연습 
 * @author ITPS
 *
 */
@Data
class MoviesList {
	private int id;
	private String url;
	private String imd_code;
	private String title;
	private String title_english;
	private String title_long;
	private String slug;
	private int year;
	private int rating;
	private int runtime;
	private ArrayList<String> genres;
	private String summary;
	private String description_full;
	private String synopsis;
	private String yt_trailer_code;
	private String language;
	private String mpa_rating;
	private String background_image;
	private String background_image_original;
	private String small_cover_image;
	private String medium_cover_image;
	private String large_cover_image;
	private String state;
}

@Data
class DataObj {
	private int movies_count;
	private int limit;
	private int page_number;
	private ArrayList<MoviesList> moviesArray;
}

@Data
public class MoviesDto {
	private String status;
	private String status_message;
	private DataObj data;
}
