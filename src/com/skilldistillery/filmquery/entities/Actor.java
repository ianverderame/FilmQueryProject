package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Actor {
	private int id;
	private String firstName;
	private String lastName;
	private ArrayList<Film> films;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return (firstName + " "+ lastName) + "(ID# " + id + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(films, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(films, other.films) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	public Actor() {
		super();
	}

	public ArrayList<Film> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<Film> films) {
		this.films = films;
	}

	public Actor(int id, String firstName, String lastName, ArrayList<Film> films) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.films = films;
	}

}
