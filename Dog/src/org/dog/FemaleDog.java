package org.dog;

public class FemaleDog extends Dog {
	public static final String GENDER = "FEMALE";

	public FemaleDog() {
		super();
		this.dogGender = GENDER;
	}

	public FemaleDog(int dogID, String dogName, int dogAge, String dogGender) {
		super(dogID, dogName, dogAge, GENDER);
	}
}