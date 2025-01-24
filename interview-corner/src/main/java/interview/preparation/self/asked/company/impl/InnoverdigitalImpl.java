package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.Iinnoverdigital;

import java.io.*;
import java.util.logging.Logger;

public class InnoverdigitalImpl implements Iinnoverdigital {

	public Object serlizeDeserlizeObject(Object obj) throws Exception {
		String file = "file.ser";
		Object rObj = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos=null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
		// serlization
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);

            // deserlization
             fis = new FileInputStream(file);
             ois = new ObjectInputStream(fis);
            rObj = ois.readObject();
        }catch (IOException e)
        {
            System.out.println("IOException encounter");
        }
    finally {
            try {
                if (fos != null)
                    fos.close();
                if (oos != null)
                    oos.close();
                if (fis != null)
                    fis.close();
                if (ois != null)
                    ois.close();
            }catch (Exception e){
                System.out.println("Unable to close Resource encounter");
            }
        }

		return rObj;
	}
}
