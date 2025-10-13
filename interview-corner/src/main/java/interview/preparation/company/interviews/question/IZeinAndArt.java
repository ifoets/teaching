package interview.preparation.company.interviews.question;

import java.io.File;
import java.util.Map;

public interface IZeinAndArt {

	/** method overloading with sub and super class */
	public void overloadMethod();

    public void overloadMethodX();

    public void overloadMethodY();

    public void overloadMethodZ();

	/** find max string count from 10 gb data file */
	public Map<String, Integer> findMaxCountStr(File f);
}
