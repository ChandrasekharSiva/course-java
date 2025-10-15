package pkg1.pkg2;

import java.util.Vector;
import java.util.Enumeration;

public class D {

   public static void main(String[] args) {

      Vector v = new Vector();

      v.addElement(new Integer(1));
      v.addElement(new Integer(2));
      v.addElement(new Integer(3));

      Enumeration e = v.elements();

      while (e.hasMoreElements()) {
         Object o = e.nextElement();
         System.out.println(o);
      }

   }
}
