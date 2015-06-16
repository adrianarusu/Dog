package org.dog;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public final class DogHelper {

	public static boolean hasDog(List<PuppyDog> dogs, PuppyDog dog) {

		for (final PuppyDog item : dogs) {
			if (item.equals(dog)) {
				dog.setDogAge(item.getDogAge());
				dog.setDogGender(item.getDogGender());
				return true;
			}
		}
		return false;
	}

	public static PuppyDog findDog(List<PuppyDog> dogs, PuppyDog dog) {
		for (final PuppyDog item : dogs) {
			if (item.equals(dog)) {
				dog.setDogName(item.getDogName());
				dog.setDogAge(item.getDogAge());
				dog.setDogGender(item.getDogGender());
				dog.setMotherID(item.getMotherID());
				dog.setFatherID(item.getFatherID());
				return dog;
			}
		}
		return dog;
	}

	public static boolean isMother(PuppyDog dog, PuppyDog mother) {
		if (dog.getMotherID() == mother.getDogID()) {
			return true;
		}
		return false;
	}

	public static boolean isFather(PuppyDog dog, PuppyDog father) {
		if (dog.getFatherID() == father.getDogID()) {
			return true;
		}
		return false;
	}

	public static boolean hasMother(PuppyDog dog) {
		if (dog.getMotherID() != 0) {
			return true;
		}
		return false;
	}

	public static boolean hasFather(PuppyDog dog) {
		if (dog.getFatherID() != 0) {
			return true;
		}
		return false;
	}

	public static void eliminateChild(Stack<PuppyDog> dogsStack,
			List<PuppyDog> dogs, List<PuppyDog> cainiAfisati, PuppyDog dog) {
		PuppyDog m = new PuppyDog(dogsStack.peek().getMotherID());
		PuppyDog f = new PuppyDog(dogsStack.peek().getFatherID());
		PuppyDog mum = DogHelper.findDog(dogs, m);
		PuppyDog dad = DogHelper.findDog(dogs, f);
		// if (dogsStack.size() > 0) {
		try {
			while (cainiAfisati.contains(dogsStack.peek())
					&& cainiAfisati.contains(mum) && cainiAfisati.contains(dad)) {
				dog = dogsStack.peek();
				m = new PuppyDog(dogsStack.peek().getMotherID());
				f = new PuppyDog(dogsStack.peek().getFatherID());
				mum = DogHelper.findDog(dogs, m);
				dad = DogHelper.findDog(dogs, f);
				dogsStack.pop();
				eliminateChild(dogsStack, dogs, cainiAfisati, dog);
			}
		} catch (final EmptyStackException e) {
			System.err.println("Empty Stack Exception");
		}

	}
}