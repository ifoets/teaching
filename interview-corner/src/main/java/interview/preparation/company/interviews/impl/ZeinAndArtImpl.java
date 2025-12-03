package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IZeinAndArt;

import java.io.File;
import java.util.Map;

public class ZeinAndArtImpl implements IZeinAndArt {

	/** method overloading with sub and super class */
	public void overloadMethod() {

		class checkOverloadCall {
			public void xyx(String str) {
				System.out.println("String xyz called");
			}

			@SuppressWarnings("unused")
			public void xyx(Object str) {
				System.out.println("Object xyz called");
			}
		}
		new checkOverloadCall().xyx(null);//str called
	}

    public void overloadMethodX() {

        class checkOverloadCall {
            public void xyx(int str) {
                System.out.println("int xyz called");
            }

            @SuppressWarnings("unused")
            public void xyx(short str) {
                System.out.println("short xyz called");
            }
        }
        new checkOverloadCall().xyx(1);//int get called
    }

    public void overloadMethodY() {

        class checkOverloadCall {
            public void xyx(double str) {
                System.out.println("double xyz called");
            }

            @SuppressWarnings("unused")
            public void xyx(float str) {
                System.out.println("float xyz called");
            }
        }
        new checkOverloadCall().xyx(1);//float get called
        new checkOverloadCall().xyx(1.0);//double get called
    }

    public void overloadMethodZ() {

        class checkOverloadCall {

            public void xyx(int str) {
                System.out.println("int xyz called");
            }

            @SuppressWarnings("unused")
            public void xyx(short str) {
                System.out.println("short xyz called");
            }

            public void xyx(double str) {
                System.out.println("double xyz called");
            }

            @SuppressWarnings("unused")
            public void xyx(float str) {
                System.out.println("float xyz called");
            }
        }
        new checkOverloadCall().xyx(1);//int get called
    }

	/** find max string count from 10 gb data file */
	public Map<String, Integer> findMaxCountStr(File f) {

		return null;
	}
}
