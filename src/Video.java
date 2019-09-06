/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001 
 * @author Samuel Harris
 * 9/29/2018
 * Purpose - Data members and operations are inherited from Media and
 * 			 more are added to this abstract class. The new data members and operations
 * 			 are created to better express video.
 **/
public abstract class Video extends Media {

	private Artist[] supportingActors;
	private int numActors; 
	private Artist director;
	private String rating; // This is not consumer rating. This is G, PG, PG-13, etc...

	public Video() {
		super();
		supportingActors = null;
		numActors = 0;
		director = null;
		rating = null;
	}

	public Video(String title, Artist majorArtist, int playingTime, Artist[] supportingActors, int numActors,
			Artist director, String rating) {
		super(title, majorArtist, playingTime);
		this.supportingActors = supportingActors;
		this.numActors = numActors;
		this.director = director;
		this.rating = rating;
	}

	public Artist[] getSupportingActors() {
		return supportingActors;
	}

	public int getNumActors() {
		return numActors;
	}

	public Artist getDirector() {
		return director;
	}

	public String getRating() {
		return rating;
	}

	public void playMedia() {
		System.out.println("\n\nNow playing: " + super.getTitle() + ", Playing time: " + super.getPlayingTime()
				+ " seconds, Rating: " + rating + ".\n\n");
		super.playMedia();
	}

	public boolean equals(Object r) {
		return (r instanceof Video && super.equals(((Video)r)) && this.supportingActors.equals(((Video)r).supportingActors) && 
				this.numActors == (((Video)r).numActors) && this.director.equals(((Video)r).director) && this.rating.equals(((Video)r).rating));
	}

	public String toString() {
		String together = "";
		
		//Used to compile all of the data in the artist toString, for each element in the array, into one string variable.
		for (int i = 0; i < supportingActors.length; i++) { 
			together += supportingActors[i].toString() + "\n";
		}
		return (super.toString() + "\n\nDirector: " + director.toString() + "\n\nNumber of actors: " + numActors
				+ "\n\nSupporting Actors: " + together + "\nRating: " + rating);
																					
	}
}
