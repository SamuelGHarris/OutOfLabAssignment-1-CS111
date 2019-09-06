/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001
 * @author Samuel Harris
 * 9/29/2018
 * Purpose - Artist has has-a inheritance with Media, Video, and Audio. 
 * 			 This allows certain data members in those classes to have more information attached to them (Artist's data members).
 **/
public class Artist implements Cloneable{
	
	private String last;
	private String first;
	private String birthDate; 
	private String twitterHandle;
	private String url;
	
	public Artist() {
		super();
		last = null;
		first = null;
		birthDate = null;
		twitterHandle = null;
		url = null;
	}
	public Artist(String last, String first, String birthDate, String twitterHandle, String url) {
		this.last = last;
		this.first = first;
		this.birthDate = birthDate;
		this.twitterHandle = twitterHandle;
		this.url = url;
	}
	
	public String getLast() {
		return last;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public String getTwitterHandle() {
		return twitterHandle;
	}
	
	public String getURL() {
		return url;
	}
	
	public Object clone() {
		Artist newA = new Artist(last, first, birthDate, twitterHandle, url);
		return newA;
	}
	
	public boolean equals(Object r) {
		return (r instanceof Artist && this.last.equals(((Artist)r).last) && this.first.equals(((Artist)r).first) 
				&& this.birthDate.equals(((Artist)r).birthDate) && this.twitterHandle.equals(((Artist)r).twitterHandle) && this.url.equals(((Artist)r).url));
	}
	
	public String toString() {
		return ("\n(First Name: " + first + "\nLast Name: " + last + "\nBirthdate: " + birthDate + "\nTwitter Handle: " 
				+ twitterHandle + "\nURL: " + url + ")");
	}
}
