package pkg1;

public class B {

   public static void main(String[] args) {

      java.util.Vector v = new java.util.Vector();

      v.addElement(new Integer(1));
      v.addElement(new Integer(2));
      v.addElement(new Integer(3));

      java.util.Enumeration e = v.elements();

      while (e.hasMoreElements()) {
         Object o = e.nextElement();
         System.out.println(o);
      }

   }
}
