package interview.preparation.self.asked;

import java.io.File;
import java.util.Map;

public class ZeinAndArtImpl implements IZeinAndArt {

	/** method overloading with sub and super class */
	public void oveloadMethod() {

		class checkOverloadCall {
			public void xyx(String str) {
				System.out.println("String xyz called");
			}

			@SuppressWarnings("unused")
			public void xyx(Object str) {
				System.out.println("Object xyz called");
			}
		}
		new checkOverloadCall().xyx(null);
	}

	/** find max string count from 10 gb data file */
	public Map<String, Integer> findMaxCountStr(File f) {

		return null;
	}
}
