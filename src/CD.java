/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001
 * @author Samuel Harris
 * 9/29/2018
 * Purpose - This class is not abstract, so many CDs can be made and held in arrays. 
 * 			 Using the super classes and this class, very detailed CDs can be created.
 **/
import java.util.Scanner;

public class CD extends Audio implements Cloneable {

	private String[] tracks;
	private int numTracks;

	public CD() {
		super();
		tracks = null;
		numTracks = 0;
	}

	public CD(String title, Artist majorArtist, int playingTime, Artist[] groupMembers, int numMembers, Artist producer,
			String[] tracks, int numTracks) {
		super(title, majorArtist, playingTime, groupMembers, numMembers, producer);
		this.tracks = tracks;
		this.numTracks = numTracks;
	}

	public String[] getTracks() {
		return tracks;
	}

	public int getNumTracks() {
		return numTracks;
	}

	public void playMedia() {
		super.playMedia();
	}

	public Object clone() {
		CD newCD = new CD(getTitle(), getMajorArtist(), getPlayingTime(), getGroupMembers(), getNumMembers(),
				getProducer(), tracks, numTracks);
		return newCD;
	}
	
	public boolean equals(Object r) {
		return (r instanceof CD && super.equals(((CD)r)) && this.tracks.equals(((CD)r).tracks) && this.numTracks == (((CD)r).numTracks));
	}

	public String toString() {
		String together = "";

		for (int i = 0; i < tracks.length; i++) {
			together += (i + 1) + ") " + tracks[i] + "\n";
		}

		return (super.toString() + "\n\nNumber of Tracks: " + numTracks + "\nTracks:\n" + together);

	}

	public CD cdFiller() {
		Scanner input = new Scanner(System.in);
		String title = null;
		String first = null;
		String last = null;
		String bdate = null;
		String twitter = null;
		String url = null;
		Artist majorArtist = null;
		int playingTime = 0;
		Artist[] groupMembers = null;
		int numMembers = 0;
		Artist producer = null;
		String[] tracks = null;
		int numTracks = 0;
		CD cd1 = null;

		System.out.println("What is the title of the CD?");
		title = input.nextLine();
		System.out.println("What is the major artist's first name?");
		first = input.nextLine();
		System.out.println("What is the major artist's last name?");
		last = input.nextLine();
		System.out.println("What is the major artist's birthdate? (mm/dd/yyyy)");
		bdate = input.nextLine();
		System.out.println("What is the major artist's twitter handle?");
		twitter = input.nextLine();
		System.out.println("What is the url associated with the major artist?");
		url = input.nextLine();

		majorArtist = new Artist(last, first, bdate, twitter, url);

		System.out.println("What is the producer's first name?");
		first = input.nextLine();
		System.out.println("What is the producer's last name?");
		last = input.nextLine();
		System.out.println("What is the producer's birthdate? (mm/dd/yyyy)");
		bdate = input.nextLine();
		System.out.println("What is the producer's twitter handle?");
		twitter = input.nextLine();
		System.out.println("What is the url associated with the producer?");
		url = input.nextLine();

		producer = new Artist(last, first, bdate, twitter, url);

		System.out.println("How many members are in the group?");
		numMembers = input.nextInt();
		input.nextLine();
		groupMembers = new Artist[numMembers];

		for (int j = 0; j < groupMembers.length; j++) {
			System.out.println("Group Member " + (j + 1) + ":\n");
			System.out.println("What is the member's first name?");
			first = input.nextLine();
			System.out.println("What is the member's last name?");
			last = input.nextLine();
			System.out.println("What is the member's birthdate? (mm/dd/yyyy)");
			bdate = input.nextLine();
			System.out.println("What is the member's twitter handle?");
			twitter = input.nextLine();
			System.out.println("What is the url associated with the member?");
			url = input.nextLine();

			groupMembers[j] = new Artist(last, first, bdate, twitter, url);
		}

		System.out.println("What is the total play time for the CD? (In seconds)");
		playingTime = input.nextInt();

		System.out.println("How many tracks does the CD have?");
		numTracks = input.nextInt();
		input.nextLine();
		tracks = new String[numTracks];

		for (int k = 0; k < tracks.length; k++) {
			System.out.println("What is the name of track " + (k + 1) + "?");
			tracks[k] = input.nextLine();
		}
		cd1 = new CD(title, majorArtist, playingTime, groupMembers, numMembers, producer, tracks, numTracks);
		
		return cd1;
	}
	
	public void listCDs(int i, CD[] cd1) {
		for (int j = 0; j < i; j++) {
			System.out.println(j + ") " + cd1[j].getTitle() + " (Number of Plays: " + cd1[j].getNumPlays() + ")"); 
																
		}
	}
}
