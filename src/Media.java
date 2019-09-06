/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001 
 * @author Samuel Harris
 * 9/29/2018 
 * Purpose - This abstract class acts as the basis for all of the
 * 			 other classes in this project, other than Artist.
 **/
public abstract class Media {

	private String title;
	private Artist majorArtist;
	private int playingTime; // playingTime is in seconds.
	private int numPlays = 0;

	public Media() {
		title = null;
		majorArtist = null;
		playingTime = 0;
		numPlays = 0;
	}

	public Media(String title, Artist majorArtist, int playingTime) { 
		this.title = title;
		this.majorArtist = majorArtist;
		this.playingTime = playingTime;
	}

	public void playMedia() {
		numPlays++;
	}

	public String getTitle() {
		return title;
	}

	public int getNumPlays() {
		return numPlays;
	}

	public int getPlayingTime() {
		return playingTime;
	}

	public Artist getMajorArtist() {
		return majorArtist;
	}

	public boolean equals(Object r) {
		return (r instanceof Media && this.title.equals(((Media) r).title)
				&& this.majorArtist.equals(((Media) r).majorArtist) && this.playingTime == (((Media) r).playingTime)
				&& this.numPlays == (((Media) r)).numPlays);
	}

	public String toString() {
		return ("Title: " + title + "\n\nMajor Artist: " + majorArtist.toString() + "\n\nPlaying Time: " + playingTime
				+ " Seconds " + "\n\nNumber of Plays: " + numPlays);
	}
}
