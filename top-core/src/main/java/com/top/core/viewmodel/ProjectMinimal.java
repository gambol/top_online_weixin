package com.top.core.viewmodel;

/**
 * @author Sebastian MA
 */
public class ProjectMinimal {

	int id;

	String name;

	public ProjectMinimal() {

	}

	public ProjectMinimal(int id, String name) {

		this.id = id;
		this.name = name;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}
}
