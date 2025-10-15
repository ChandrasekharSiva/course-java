import dlists.List;
import dlists.Node;
import dlists.IsNodeObject;
import dlists.IntegrityException;

class StringNode implements IsNodeObject {
   private String s;
   StringNode(String anS) {
      s = anS;
   }
   public String toString() {
      return s;
   }
}


class ListTest {
   public static void main(String[] args) {

      List x = new List();

      x.add(new StringNode("apple"));
      x.add(new StringNode("banana"));
      x.add(new StringNode("carrot"));

      System.out.println(x); // prints: apple banana carrot

      x.getFirst().getNext().remove(); // removes the second element

      System.out.println(x); // prints: apple carrot

      x.getLast().remove(); // removes the last element

      System.out.println(x); // prints: apple

   }
}
