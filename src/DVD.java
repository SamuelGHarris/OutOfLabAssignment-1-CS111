/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001
 * @author Samuel Harris
 * 9/29/2018
 * Purpose - This class is not abstract, so many DVDs can be made and held in arrays. 
 * 			 Using the super classes and this class, very detailed DVDs can be created.
 **/
import java.util.Scanner;

public class DVD extends Video implements Cloneable {

	private String[] specialFeatures;
	private int numFeatures; 
	private boolean wideScreenFormat;
	private String[] soundOptions;
	private int numSoundOptions;

	public DVD() {
		super();
		specialFeatures = null;
		numFeatures = 0;
		wideScreenFormat = false;
		soundOptions = null;
		numSoundOptions = 0;
	}

	public DVD(String title, Artist majorArtist, int playingTime, Artist[] supportingActors, int numActors,
			Artist director, String rating, String[] specialFeatures, int numFeatures, boolean wideScreenFormat,
			String[] soundOptions, int numSoundOptions) {
		super(title, majorArtist, playingTime, supportingActors, numActors, director, rating);
		this.specialFeatures = specialFeatures;
		this.numFeatures = numFeatures;
		this.wideScreenFormat = wideScreenFormat;
		this.soundOptions = soundOptions;
		this.numSoundOptions = numSoundOptions;
	}

	public String[] getSpecialFeatures() {
		return specialFeatures;
	}

	public int getNumFeatures() {
		return numFeatures;
	}

	public boolean getWideScreeFormat() {
		return wideScreenFormat;
	}

	public String[] getSoundOptions() {
		return soundOptions;
	}

	public int getNumSoundOptions() {
		return numSoundOptions;
	}

	public void playMedia() {
		super.playMedia();
	}

	public Object clone() {
		DVD newD = new DVD(getTitle(), getMajorArtist(), getPlayingTime(), getSupportingActors(), getNumActors(),
				getDirector(), getRating(), specialFeatures, numFeatures, wideScreenFormat, soundOptions,
				numSoundOptions);
		return newD;
	}
	
	public boolean equals(Object r) {
		return (r instanceof DVD && super.equals(((DVD)r)) && this.specialFeatures.equals(((DVD)r).specialFeatures) && this.numFeatures == ((DVD)r).numFeatures 
				&& this.wideScreenFormat == ((DVD)r).wideScreenFormat && this.soundOptions.equals(((DVD)r).soundOptions) && this.numSoundOptions == ((DVD)r).numSoundOptions);
	}

	public String toString() {
		String together = "";
		String together2 = "";

		for (int i = 0; i < specialFeatures.length; i++) {
			together += specialFeatures[i] + "\n";
		}
		for (int i = 0; i < soundOptions.length; i++) {
			together2 += soundOptions[i] + "\n";
		}

		return (super.toString() + "\n\nNumber of Features: " + numFeatures + "\n\nSpecial Features:\n" + together
				+ "\nWide Screen Format: " + wideScreenFormat + "\n\nNumber of Sound Options: " + numSoundOptions
				+ "\n\nSound Options:\n" + together2);
	}

	public DVD dvdFiller() {
		Scanner input = new Scanner(System.in);
		String title = null;
		String first = null;
		String last = null;
		String bdate = null;
		String twitter = null;
		String url = null;
		String response = null;
		Artist majorArtist = null;
		int playingTime = 0;
		Artist[] supportingActors = null;
		int numActors = 0;
		Artist director = null;
		String rating = null;
		String[] specialFeatures = null;
		int numFeatures = 0;
		boolean wideScreenFormat = false;
		String[] soundOptions = null;
		int numSoundOptions = 0;
		DVD dvd1 = null;

		System.out.println("What is the title of the DVD?");
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

		System.out.println("What is the director's first name?");
		first = input.nextLine();
		System.out.println("What is the director's last name?");
		last = input.nextLine();
		System.out.println("What is the director's birthdate? (mm/dd/yyyy)");
		bdate = input.nextLine();
		System.out.println("What is the director's twitter handle?");
		twitter = input.nextLine();
		System.out.println("What is the url associated with the director?");
		url = input.nextLine();

		director = new Artist(last, first, bdate, twitter, url);

		System.out.println("How many actors are in the group?");
		numActors = input.nextInt();
		input.nextLine();
		supportingActors = new Artist[numActors];

		for (int j = 0; j < supportingActors.length; j++) {
			System.out.println("Actor " + (j + 1) + ":\n");
			System.out.println("What is the actor's first name?");
			first = input.nextLine();
			System.out.println("What is the actor's last name?");
			last = input.nextLine();
			System.out.println("What is the actor's birthdate? (mm/dd/yyyy)");
			bdate = input.nextLine();
			System.out.println("What is the actor's twitter handle?");
			twitter = input.nextLine();
			System.out.println("What is the url associated with the actor?");
			url = input.nextLine();

			supportingActors[j] = new Artist(last, first, bdate, twitter, url);

		}
		System.out.println("What is the total play time for the DVD? (In seconds)");
		playingTime = input.nextInt();
		input.nextLine();

		System.out.println("What is the rating of the DVD? (G, PG, PG-13, etc...)");
		rating = input.nextLine();

		System.out.println("Is the DVD in wide screen format? (Yes/No)");
		response = input.nextLine();
		if (response.equalsIgnoreCase("No")) {
			wideScreenFormat = false;
		} else if (response.equalsIgnoreCase("Yes")) {
			wideScreenFormat = true;
		}

		System.out.println("How many special features are present in the DVD?");
		numFeatures = input.nextInt();
		input.nextLine();
		specialFeatures = new String[numFeatures];

		for (int l = 0; l < specialFeatures.length; l++) {
			System.out.println("What is special feature " + (l + 1));
			specialFeatures[l] = input.nextLine();
		}

		System.out.println("How many sound options are present on the DVD?");
		numSoundOptions = input.nextInt();
		input.nextLine();
		soundOptions = new String[numSoundOptions];

		for (int v = 0; v < soundOptions.length; v++) {
			System.out.println("What is sound option " + (v + 1));
			soundOptions[v] = input.nextLine();
		}

		dvd1 = new DVD(title, majorArtist, playingTime, supportingActors, numActors, director, rating, specialFeatures,
				numFeatures, wideScreenFormat, soundOptions, numSoundOptions);

		return dvd1;
	}
	
	public void listDVDs(int k, DVD[] dvd1) {
		for (int j = 0; j < k; j++) {
			System.out.println(j + ") " + dvd1[j].getTitle() + " (Number of Plays: " + dvd1[j].getNumPlays() + ")");
		}
	}
}
