package org.dog;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestDog {
	public final static String DELIMITATOR = ",";

	public static void main(String[] args) throws Exception {
		final String in = args[4];
		final String out = args[5];

		System.out.println(args[4]);
		System.out.println(args[5]);

		final BufferedReader br = Files.newBufferedReader(Paths.get(in),
				Charset.forName("UTF-8"));

		final File printParents = new File(out);
		final PrintWriter wrtP = new PrintWriter(printParents, "UTF-8");

		final List<PuppyDog> dogs = new ArrayList<PuppyDog>();
		final List<PuppyDog> dogs1 = new ArrayList<PuppyDog>();
		final List<PuppyDog> dogs2 = new ArrayList<PuppyDog>();

		String line = "";
		boolean bIgnoreFirstLine = true;

		while ((line = br.readLine()) != null) {
			if (bIgnoreFirstLine) {
				bIgnoreFirstLine = false;
				continue;
			}

			final String[] columns = line.split(DELIMITATOR, -1);

			if (columns[4].equals("") && columns[5].equals("")) {
				dogs1.add(new PuppyDog(Integer.parseInt(columns[0]),
						columns[1], Integer.parseInt(columns[2]), columns[3],
						0, 0));

				continue;

			} else {
				dogs2.add(new PuppyDog(Integer.parseInt(columns[0]),
						columns[1], Integer.parseInt(columns[2]), columns[3],
						Integer.parseInt(columns[4]), Integer
								.parseInt(columns[5])));

			}

		}

		dogs.addAll(dogs2);
		dogs.addAll(dogs1);
		// dogs.toString();

		final List<PuppyDog> cainiAfisati = new ArrayList<PuppyDog>();

		final PuppyDog dogFamilyTree = new PuppyDog(Integer.parseInt(args[0]),
				args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));

		if (!DogHelper.findDog(dogs, dogFamilyTree).equals(dogFamilyTree)) {
			wrtP.println("Dog not found");
		} else {

			wrtP.println("The dog for which the family tree needs to be generated is: ");
			wrtP.println(dogFamilyTree.getDogName() + ","
					+ dogFamilyTree.getDogAge() + ","
					+ dogFamilyTree.getDogGender());
		}

		final Stack<PuppyDog> dogsStack = new Stack<PuppyDog>();
		cainiAfisati.add(dogFamilyTree);
		PuppyDog.getFamilyTree(dogs, dogFamilyTree, dogFamilyTree, wrtP, 1,
				dogsStack, cainiAfisati);

		wrtP.close();
		System.out.println("ended");

	}
}
