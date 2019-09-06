/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001 
 * @author Samuel Harris
 * 9/29/2018 
 * Purpose - Data members and operations are inherited from Media and
 * 			 more are added to this abstract class. The new data members and operations
 * 			 are created to better express audio.
 **/
public abstract class Audio extends Media {

	private Artist[] groupMembers;
	private int numMembers;
	private Artist producer;

	public Audio() {
		super();
		groupMembers = null;
		producer = null;
	}

	public Audio(String title, Artist majorArtist, int playingTime, Artist[] groupMembers, int numMembers,
			Artist producer) {
		super(title, majorArtist, playingTime);
		this.groupMembers = groupMembers;
		this.numMembers = numMembers;
		this.producer = producer;
	}

	public Artist[] getGroupMembers() {
		return groupMembers;
	}

	public int getNumMembers() {
		return numMembers;
	}

	public Artist getProducer() {
		return producer;
	}

	public void playMedia() {
		System.out.println(
				"\n\nNow playing: " + super.getTitle() + ", Playtime: " + super.getPlayingTime() + " seconds.\n\n");
		super.playMedia();
	}

	public boolean equals(Object r) {
		return (r instanceof Audio && super.equals(((Audio) r)) && this.groupMembers.equals(((Audio) r).groupMembers)
				&& this.numMembers == (((Audio) r).numMembers) && this.producer.equals(((Audio) r).producer));
	}

	public String toString() {
		String together = "";

		for (int i = 0; i < groupMembers.length; i++) {
			together += groupMembers[i].toString() + "\n";
		}

		return (super.toString() + "\n\nNumber of Members: " + numMembers + "\nGroup Members: " + together
				+ "\nProducer: " + producer.toString());
	}
}
