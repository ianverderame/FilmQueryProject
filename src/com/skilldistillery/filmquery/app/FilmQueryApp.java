package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//   try {
//	  Film film = db.findFilmById(1);
//    System.out.println(film);
//   }
//   catch(NullPointerException e) {
//   }
//	}

	private void launch() {
		Scanner sc = new Scanner(System.in);
		startUserInterface(sc);
		sc.close();
	}

	private void startUserInterface(Scanner sc) {

		boolean keepGoing = true;
		Film film;
		List<Film> filmList = new ArrayList<>();

		while (keepGoing) {
			System.out.println(
					"\nWould you like to: \n1. Look up a film by its ID number\n2. Look up a film by keyword\n3. Exit the application");
			int input = sc.nextInt();
			sc.nextLine();
			switch (input) {

			case 1:
				System.out.print("Please enter a film ID number: ");
				film = db.findFilmById(sc.nextInt());
				if (film == null)
					System.out.println("\nNo movies were found with this ID, please try again");
				else {
					String language = db.getFilmLanguage(film.getLanguageId());
					List<Actor> actorList = new ArrayList<>();
					actorList = film.getActors();

					System.out.println("\nYou have selected " + film.getTitle() + "\nRelase year: "
							+ film.getReleaseYear() + "\nRating: " + film.getRating() + "\nLanguage: " + language
							+ "\nDescription: " + film.getDescription());
					System.out.println("There are " + actorList.size() + " actors in " + film.getTitle() + ": "
							+ actorList.toString() + "\n");

				}
				break;

			case 2:
				System.out.print("Please enter a keyword to search films titles and descriptions: ");
				filmList = db.findFilmByKeyword(sc.nextLine());
				int count = 0;

				if (filmList.size() == 0) {
					System.out.println("\nNo movies were found with that keyword");
				} else {
					System.out.println("\nYou have selected the following " + filmList.size() + " movies:\n");

					for (Film film2 : filmList) {
						String language = "";
						List<Actor> actorList = new ArrayList<>();

						language = db.getFilmLanguage(film2.getLanguageId());
						actorList = film2.getActors();

						System.out.println("Movie " + ++count + ": " + film2.getTitle() + "\nRelease year: "
								+ film2.getReleaseYear() + "\nRating: " + film2.getRating() + "\nLanguage: " + language
								+ "\nDescription: " + film2.getDescription());
						System.out.println("There are " + actorList.size() + " actors in " + film2.getTitle() + ": "
								+ actorList.toString() + "\n");
					}

				}
				break;

			case 3:
				keepGoing = false;
				System.out.println("Exiting Application... Bye!");
				break;

			default:
				System.out.println("Please enter only 1-3");
				break;
			}
		}
	}

}
