package interview.preparation.self.asked.company.question;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InnoverdigitalImpl implements Iinnoverdigital {

	public Object serlizeDeserlizeObject(Object obj) throws Exception {
		String file = "file.ser";
		Object rObj = null;
		// serlization
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		fos.close();
		oos.close();

		// deserlization
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		rObj = ois.readObject();
		fis.close();
		ois.close();
		return rObj;
	}
}
