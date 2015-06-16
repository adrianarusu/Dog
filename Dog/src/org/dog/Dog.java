package org.dog;

public class Dog {
	protected int dogID;
	protected int dogAge;
	protected String dogName;
	protected String dogGender;

	public Dog() {
		this.dogID = 0;
		this.dogAge = 0;
		this.dogName = null;
		this.dogGender = null;
	}

	public Dog(int dogID) {
		this.dogID = dogID;
		this.dogName = null;
		this.dogAge = 0;
		this.dogGender = null;
	}

	public Dog(String name) {
		this.dogID = 0;
		this.dogName = name;
		this.dogAge = 0;
		this.dogGender = null;
	}

	public Dog(int dogID, String dogName) {
		this.dogID = dogID;
		this.dogName = dogName;
		this.dogAge = 0;
		this.dogGender = null;
	}

	public Dog(final int dogID, final String dogName, final int dogAge) {
		this.dogID = dogID;
		this.dogName = dogName;
		this.dogAge = dogAge;
	}

	public Dog(final int dogID, final String dogName, final int dogAge,
			final String dogGender) {
		this.dogID = dogID;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogGender = dogGender;
	}

	public void setDogID(int dogID) {
		this.dogID = dogID;
	}

	public int getDogID() {
		return this.dogID;
	}

	public void setDogAge(int dogAge) {
		this.dogAge = dogAge;
	}

	public int getDogAge() {
		return this.dogAge;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogName() {
		return this.dogName;
	}

	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}

	public String getDogGender() {
		return this.dogGender;
	}

	@Override
	public boolean equals(Object dog) {
		if (dog == this) {
			return true;
		}
		if ((dog == null) || (dog.getClass() != this.getClass())) {
			return false;
		}
		final Dog dog2 = (Dog) dog;
		return (this.getDogID() == dog2.getDogID());
	}

	@Override
	public String toString() {
		final String printDog = "Dog [id=" + this.dogID + ",name="
				+ this.dogName + ",age=" + this.dogAge + ", gender=" + "]";
		System.out.println(printDog);
		return printDog;
	}
}