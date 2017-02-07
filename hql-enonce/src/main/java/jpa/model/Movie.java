package jpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany
	private List<Actor> actors = new ArrayList<Actor>();

	@Id
	private Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REALEASE_DATE")
	private Date releaseDate;

	@Version
	private int version;

	public Movie() {
	}

	public Movie(String name, Date releaseDate) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public int getVersion() {
		return this.version;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", version=" + version + "]";
	}

}
