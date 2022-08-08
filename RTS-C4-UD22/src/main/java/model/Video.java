package model;

public class Video {
	/** Attributes */
	private int id;
	
	private String title;
	
	private String director;
	
	private int cli_id;

	/**
	 * Constructor
	 * @param id
	 * @param title
	 * @param director
	 * @param cli_id
	 */
	public Video(String title, String director, int cli_id) {
		this.title = title;
		this.director = director;
		this.cli_id = cli_id;
	}

	/**Getters & Setters */
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the cli_id
	 */
	public int getCli_id() {
		return cli_id;
	}

	/**
	 * @param cli_id the cli_id to set
	 */
	public void setCli_id(int cli_id) {
		this.cli_id = cli_id;
	}
	
	
	
	
}