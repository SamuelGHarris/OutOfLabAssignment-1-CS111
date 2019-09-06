/**
 * Outside Lab Programming Assignment 1
 * CS 111 Section No.001
 * @author Samuel Harris
 * 9/29/2018
 * Purpose - This class interacts with the user in order to create CDs and DVDs. 
 * 			 The user is able to view different portions of the data individually, through the use of a menu.
 **/
import java.util.Scanner;
import java.util.InputMismatchException;

public class MediaApp {
	public static void main(String args[]) {

		String response = null;
		String[] soundOptions = null;
		String[] specialFeatures = null;
		String[] tracks = null;

		int num = 0;
		int numi = 0;
		int numk = 0;
		int i = 1;
		int k = 1;

		Artist director = null;
		Artist[] groupMembers = null;
		Artist majorArtist = null;
		Artist producer = null;
		Artist[] supportingActors = null;

		CD[] cd1 = new CD[100];
		DVD[] dvd1 = new DVD[100];

		boolean value = true;

		Scanner input = new Scanner(System.in);
		CD accessCD = new CD();
		DVD accessDVD = new DVD();

		//Sample CDs and DVDs. These fill the first index on both the CD and DVD object arrays.
		majorArtist = new Artist("Jenkens", "John", "08/11/1989", "@jjenkens", "www.johnSummersEnd.com");
		producer = new Artist("Jenkens", "James", "04/12/1987", "@jamesistheman", "www.jamesJ.com");
		groupMembers = new Artist[2];
		groupMembers[0] = new Artist("Fresh", "Samuel", "09/02/1978", "@StheFresh", "www.samelfresh.com");
		groupMembers[1] = new Artist("Jones", "Bob", "01/04/1990", "@brotherjones", "www.bobjones.com");
		tracks = new String[3];
		tracks[0] = "Walk in the Woods";
		tracks[1] = "Treasure Hunt";
		tracks[2] = "Beach Ball";
		cd1[0] = new CD("Summers end", majorArtist, 600, groupMembers, 2, producer, tracks, 3);

		majorArtist = new Artist("Harris", "Samuel", "08/12/1997", "@sammmharris", "www.samH.com");
		director = new Artist("Smith", "Greg", "03/23/1979", "@gregsmith", "www.gregsmith.com");
		supportingActors = new Artist[2];
		supportingActors[0] = new Artist("Ramierez", "Alfonso", "09/08/1983", "@alfonsothegreat", "www.alfRam.com");
		supportingActors[1] = new Artist("Grey", "Sean", "10/12/1999", "@seanG", "www.seangrey.com");
		specialFeatures = new String[2];
		specialFeatures[0] = "Deleted Scenes";
		specialFeatures[1] = "Behind the Scenes";
		soundOptions = new String[2];
		soundOptions[0] = "Surround Sound Type";
		soundOptions[1] = "Volume";
		dvd1[0] = new DVD("Winters Dream", majorArtist, 1800, supportingActors, 2, director, "PG", specialFeatures, 2,
				true, soundOptions, 2);

		System.out.println("Welcome to the Media Application...\n\n");

		while (value) {
			System.out.println("     -Please Choose a Number From Below-");
			System.out.println("____________________MENU_______________________ ");
			System.out.println("1) Create CDs and DVDs.");
			System.out.println("2) List all CDs or DVDs in the current collection."); 
																				
			System.out.println("3) List all of the data for a particular CD or DVD.");
			System.out.println("4) List all of the data elements for the major artist of a particular CD or DVD.");
			System.out.println("5) Play a particular CD or DVD.");
			System.out.println("6) List the number of plays for a particular CD or DVD.");
			try {
				num = input.nextInt();
				input.nextLine();
				//Methods in the CD and DVD class hold the bulk of the code for the first selection in the menu.
				if (num == 1) {		
					System.out.println("Which one would you like to create? (CD/DVD)");
					response = input.nextLine();
					if (response.equalsIgnoreCase("CD")) {
						System.out.println("How many CDs would you like to create? (" + i + "/100 CDs made)");
						numi = input.nextInt();
						if ((numi + i) > 100) {  //Used to make sure no negative numbers are entered and that no more than 100 CDs are made.
							System.out.println("You went past the max of 100.");
							System.out.println("Please try again.");
						} else if (numi < 0) {
							System.out.println("You entered a negative number.");
							System.out.println("Please try again.");
						} else if (numi >= 0 && numi <= 100) {
							numi += i; //i was previously added to numi in order to prevent some CDs from being replaced with new ones.
							input.nextLine();
							while (i < numi) { 
								System.out.println("CD: " + i);
								cd1[i] = accessCD.cdFiller();
								i++;
							}
						}
					} else if (response.equalsIgnoreCase("DVD")) {
						System.out.println("How many DVDs would you like to create? (" + k + "/100 DVDs made)");
						numk = input.nextInt();
						if ((numk + k) > 100) { 
							System.out.println("You went past the max of 100.");
							System.out.println("Please try again.");
						} else if (numk < 0) {
							System.out.println("You entered a negative number.");
							System.out.println("Please try again.");
						} else if ((numk + k) >= 0 && (numk + k) <= 100) {
							numk += k;
							input.nextLine();
							while (k < numk) {
								System.out.println("DVD: " + k);
								dvd1[k] = accessDVD.dvdFiller();
								k++;
							}
						}
					}
					//The listDVDs and listCDs methods are located in the DVD and CD classes respectively.
				} else if (num == 2) {
					System.out.println("\nCDs:");
					accessCD.listCDs(i, cd1);
					System.out.println("\nDVDs:");
					accessDVD.listDVDs(k, dvd1);
					System.out.println("\n");
				} else if (num == 3) {
					System.out.println("Which type of media do you want to look at? (CD/DVD)");
					response = input.nextLine();
					if (response.equalsIgnoreCase("CD")) {
						System.out.println(
								"\nPlease pick a CD from the collection: (Please respond with the integer on the left side.)");
						accessCD.listCDs(i, cd1);
						num = input.nextInt();
						System.out.println("\n" + cd1[num].toString());
					} else if (response.equalsIgnoreCase("DVD")) {
						System.out.println(
								"\nPlease pick a DVD from the collection: (Please respond with the integer on the left side.)");
						accessDVD.listDVDs(k, dvd1);
						num = input.nextInt();
						System.out.println("\n" + dvd1[num].toString());
					}
				} else if (num == 4) {
					System.out.println("Which type of media are you interested in? (CD/DVD)");
					response = input.nextLine();
					if (response.equalsIgnoreCase("CD")) {
						System.out.println(
								"\nPlease pick a CD from the collection: (Please respond with the integer on the left side.)");
						accessCD.listCDs(i, cd1);
						num = input.nextInt();
						System.out.println("\n" + cd1[num].getMajorArtist().toString() + "\n");
					} else if (response.equalsIgnoreCase("DVD")) {
						System.out.println(
								"\nPlease pick a DVD from the collection: (Please respond with the integer on the left side.)");
						accessDVD.listDVDs(k, dvd1);
						num = input.nextInt();
						System.out.println("\n" + dvd1[num].getMajorArtist().toString() + "\n");
					}
				} else if (num == 5) {
					System.out.println("Which type of media are you interested in? (CD/DVD)");
					response = input.nextLine();
					if (response.equalsIgnoreCase("CD")) {
						System.out.println(
								"\nPlease pick a CD from the collection: (Please respond with the integer on the left side.)");
						accessCD.listCDs(i, cd1);
						num = input.nextInt();
						System.out.println();
						cd1[num].playMedia();

					} else if (response.equalsIgnoreCase("DVD")) {
						System.out.println(
								"\nPlease pick a DVD from the collection: (Please respond with the integer on the left side.)");
						accessDVD.listDVDs(k, dvd1);
						num = input.nextInt();
						System.out.println();
						dvd1[num].playMedia();
					}
				} else if (num == 6) {
					System.out.println("Which type of media are you interested in? (CD/DVD)");
					response = input.nextLine();
					if (response.equalsIgnoreCase("CD")) {
						System.out.println(
								"\nPlease pick a CD from the collection: (Please respond with the integer on the left side.)");
						accessCD.listCDs(i, cd1);
						num = input.nextInt();
						System.out.println("\n" + cd1[num].getTitle() + " has been played " + cd1[num].getNumPlays()
								+ " times.\n");
					} else if (response.equalsIgnoreCase("DVD")) {
						System.out.println(
								"\nPlease pick a DVD from the collection: (Please respond with the integer on the left side.)");
						accessDVD.listDVDs(k, dvd1);
						num = input.nextInt();
						System.out.println("\n" + dvd1[num].getTitle() + " has been played " + dvd1[num].getNumPlays()
								+ " times.\n");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nYou entered a value of an incorrect type.");
				System.out.println("Please try again.\n");
				input.nextLine();
			} catch (NullPointerException e) {
				System.out.println("\nYou entered a number that did not represent an existing element in an arrary.");
				System.out.println("Please try again.\n");
				input.nextLine();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nYou tried to access a value outside of the array.");
				System.out.println("Please try again.\n");
				input.nextLine();
			}
		}
	}
}
