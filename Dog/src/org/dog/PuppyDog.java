package org.dog;

import java.io.PrintWriter;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class PuppyDog extends Dog {
	private int motherID;
	private int fatherID;

	public PuppyDog() {
		super();
		this.motherID = 0;
		this.fatherID = 0;
	}

	public PuppyDog(String dogName) {
		super();
		this.motherID = 0;
		this.fatherID = 0;
	}

	public PuppyDog(int dogID) {
		super(dogID);
		this.motherID = 0;
		this.fatherID = 0;
	}

	public PuppyDog(int dogID, String dogName, int dogAge, String dogGender) {
		super(dogID, dogName, dogAge, dogGender);
		this.motherID = 0;
		this.fatherID = 0;
	}

	public PuppyDog(int dogID, String dogName, int motherID, int fatherID) {
		super(dogID, dogName);
		this.motherID = motherID;
		this.fatherID = fatherID;
	}

	public PuppyDog(int dogID, String dogName, int dogAge, String dogGender,
			int motherID, int fatherID) {
		super(dogID, dogName, dogAge, dogGender);
		this.motherID = motherID;
		this.fatherID = fatherID;
	}

	public void setMotherID(int motherID) {
		this.motherID = motherID;
	}

	public int getMotherID() {
		return this.motherID;
	}

	public void setFatherID(int fatherID) {
		this.fatherID = fatherID;
	}

	public int getFatherID() {
		return this.fatherID;
	}

	public void setParents(int motherID, int fatherID) {
		this.motherID = motherID;
		this.fatherID = fatherID;
	}

	public String getParents() {
		final String parents = "mother = " + this.getMotherID() + ", father = "
				+ this.getFatherID();
		return parents;
	}

	@Override
	public String toString() {
		final String printPuppy = "Dog [id = " + this.getDogID() + ", name = "
				+ this.getDogName() + ", age = " + this.getDogAge()
				+ ", gender = " + this.getDogGender() + ", mother = "
				+ this.getMotherID() + ", father = " + this.getFatherID() + "]";
		System.out.println(printPuppy);
		return printPuppy;
	}

	@Override
	public boolean equals(Object dog) {
		if (dog == this) {
			return true;
		}
		if ((dog == null) || (dog.getClass() != this.getClass())) {
			return false;
		}
		final PuppyDog dog2 = (PuppyDog) dog;
		return (this.getDogID() == dog2.getDogID());
	}

	public static void getFamilyTree(List<PuppyDog> dogs, PuppyDog dog,
			PuppyDog dogFamilyTree, PrintWriter wrtP, int level,
			Stack<PuppyDog> dogsStack, List<PuppyDog> cainiAfisati) {

		final String tab = "\t";

		if (!dogsStack.contains(dogFamilyTree)) {
			dogsStack.add(dogFamilyTree);
		}

		if (!cainiAfisati.contains(dogFamilyTree)) {
			cainiAfisati.add(dogFamilyTree);
		}

		if ((DogHelper.hasMother(dog) == true)) {
			final PuppyDog mother = new PuppyDog(dog.getMotherID());
			if ((DogHelper.findDog(dogs, mother).getDogID() == mother
					.getDogID())) {
				if (dogsStack.contains(mother) == false) {
					dogsStack.push(mother);
					System.out.println(StringUtils.repeat(tab, level)
							+ dogsStack.peek().getDogName() + ", "
							+ dogsStack.peek().getDogAge() + ", "
							+ dogsStack.peek().getDogGender());
					dog = mother;
					if (!cainiAfisati.contains(dog)) {
						cainiAfisati.add(dog);
					}
					level++;
				}
			}
		}

		else {
			int stackSize = dogsStack.size();
			while (DogHelper.hasFather(dog) == false) {
				if (stackSize > 0) {
					stackSize = stackSize - 2;
					dog = dogsStack.get(stackSize);
				} else {
					// System.out.println("Empty stack!");
					// dog = dogFamilyTree;
					// continue;
					break;
				}
			}
			while (DogHelper.hasFather(dog) == true) {
				final PuppyDog father = new PuppyDog(dog.getFatherID());
				if ((DogHelper.findDog(dogs, father).getDogID() == father
						.getDogID())) {
					dogsStack.push(father);
					level--;
					System.out.println(StringUtils.repeat(tab, level)
							+ dogsStack.peek().getDogName() + ", "
							+ dogsStack.peek().getDogAge() + ", "
							+ dogsStack.peek().getDogGender());
					if (!cainiAfisati.contains(father)) {
						cainiAfisati.add(father);
					}

					// verific daca dog are parinti inainte sa pop()

					if ((dogsStack.peek().getMotherID() != 0)
							&& (dogsStack.peek().getFatherID() != 0)) {
						dog = dogsStack.peek();
						level++;
						getFamilyTree(dogs, dog, dogFamilyTree, wrtP, level,
								dogsStack, cainiAfisati);
					} else {

						// scot afara din stack tot ce nu mai are parinti

						while ((dogsStack.peek().getMotherID() == 0)
								&& (dogsStack.peek().getFatherID() == 0)) {
							dogsStack.pop();
						}
						dog = dogsStack.peek();
						// if (dogsStack.size() >= 2) {
						// dog = dogsStack.get(dogsStack.size() - 2);
						// } else {
						// dog = dogsStack.get(dogsStack.size() - 1);
						// }
						DogHelper.eliminateChild(dogsStack, dogs, cainiAfisati,
								dog);

					}

				}

			}

		}

		getFamilyTree(dogs, dog, dogFamilyTree, wrtP, level, dogsStack,
				cainiAfisati);
	}

}
