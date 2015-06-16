package org.dog;

import org.testng.annotations.Test;

public class TestMain {
	@Test
	public void test() throws Exception {
		TestDog.main(new String[] { "1", "Beethoven", "2", "6",
				"C:\\JAVA\\001-wks\\Dog\\files\\Dogs1.csv",
				"C:\\JAVA\\001-wks\\Dog\\files\\SeeDogs.txt" });
	}

}
