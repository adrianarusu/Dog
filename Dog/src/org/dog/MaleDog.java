package org.dog;

public class MaleDog extends Dog {
	public static final String GENDER = "MALE";

	public MaleDog() {
		super();
		this.dogGender = GENDER;
	}

	public MaleDog(int dogID, String dogName, int dogAge, String dogGender) {
		super(dogID, dogName, dogAge, GENDER);
	}
}