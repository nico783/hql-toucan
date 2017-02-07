package jpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Movie implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinTable(name = "MOVIE_ACTOR", joinColumns = { @JoinColumn(name = "MOVIES_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ACTORS_ID") })
	private List<Actor> actors = new ArrayList<Actor>();

	@GenericGenerator(strategy = "org.hibernate.id.enhanced.TableGenerator", name = "movieGen", parameters = {
			@Parameter(name = "table_name", value = "ID_GENERATOR"),
			@Parameter(name = "value_column_name", value = "GEN_VALUE"),
			@Parameter(name = "segment_column_name", value = "GEN_ID"),
			@Parameter(name = "segment_value", value = "MOVIE_ID"), 
			@Parameter(name = "increment_size", value = "50"),
			@Parameter(name = "optimizer", value = "pooled") })
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "movieGen")
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
