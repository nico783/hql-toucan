package jpa.dto;

public class MovieActorNames {

	private String actorName;

	private String movieName;

	public MovieActorNames(String movieName, String actorName) {
		super();
		this.movieName = movieName;
		this.actorName = actorName;
	}

	public String getActorName() {
		return actorName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
