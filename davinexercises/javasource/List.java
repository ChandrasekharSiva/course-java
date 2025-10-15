package dlists;

/**
 * 
 * A class for manipulating doubly-linked lists.
 * 
 * @author Davin Pearson
 * @see    Node
 * @see    IsNodeObject
 * @see    IntegrityException
 * 
 */
public class List  
{ 
   /* Underscores are used in this file to
    * emphasise package visibility.
    */
   Node _first;   
   Node _last;   
    
   public List() {      
      _first = null;          
      _last  = null;          
   }    

   /** Returns the first node of the list.
    */
   public Node getFirst() { return _first; }  


   /** Returns the last node of the list.
    */
   public Node getLast() { return _last; } 
 
   /**  Alias for {@link #addToEnd(dlists.IsNodeObject)
    * addToEnd}.
    * 
    * @see #addToEnd(dlists.IsNodeObject)
    * 
    */
   public void add(IsNodeObject o) {
      addToEnd(o);
   }

   /** Adds a node onto the start of the list.
    * 
    * @param   o    The object to add.
    * 
    * */
   public void addToStart(IsNodeObject o) {

      Node n = new Node();

      n._owner   = this;
      n._prev    = null;
      n._next    = _first;
      n.current  = o;

      if (_first != null) {
         _first._prev = n;
      }

      _first = n;

      if (_last == null) {
         _last = n;
      }

   }

   /** Adds a node onto the end of the list. */
   public void addToEnd(IsNodeObject o) {
      Node n = new Node();
      
      n._owner   = this;
      n._prev    = _last;
      n._next    = null;
      n.current  = o;

      if (_last != null) {
         _last._next = n;
      }

      _last = n;

      if (_first == null) {
         _first = n;
      }

   }

   /** Returns the length of the list. */
   public int length() {
      int count = 0;
      for (Node n = _first; n != null; n=n.getNext()) {
         count++;
      }
      return count;
   }
   
   /** Returns whether or not the current list is empty.
    * The {@link #length() length()} method
    * makes this method logically unnecessary, but it is
    * convenient nonetheless.  
    */
   public boolean isEmpty() {
      return _first == null;
   }

   /** Reverses order of the list elements. */
   public void reverse() {

      Node n_next = null;
      for (Node n = _first; n != null; n=n_next) {
         n_next = n.getNext();
         Node tmp = n._prev;
         n._prev = n._next;
         n._next = tmp;
      }

      Node tmp = _first;
      _first = _last;
      _last  = tmp;
   }

   /* Returns a shallow copy of the current list. */
//   List clone();

   /** Removes all of the elements of the list.
    */
   public void removeAll() {

      Node n2;
      for (Node n=_first; n!=null; n=n2) {
         n2 = n.getNext();
         n.current = null;
         n._prev   = n._next;
         n._next   = n._prev;
         // FIXME: check for owner!!!
      }
   }
   
   
   /** Checks that the internals of the list are in a
    * consistent state.  Naturally this takes some time!  If
    * the check fails, this indicates a bug in the
    * <code>dlists</code> system.
    *  
    * @exception IntegrityException if the check fails 
    */
   public void checkIntegrity() throws IntegrityException {

      Node n = _first;
      if (n != null) {
         for (; n.getNext() != null; n=n.getNext()) {
         }
      }

      if (n != _last) {
         throw new IntegrityException("Reference _last does not agree with last element of list");
      }

      n = _last;
      if (n != null) {
         for (; n.getPrev() != null; n=n.getPrev()) {
         }
      }

      if (n != _first) {
         throw new IntegrityException("Reference _first does not agree with last element of list");
      }

      n = _first;
      boolean ok = true;
      for (; n != null; n=n.getNext()) {
         if (n._owner != this) {
            ok = false;
         }
      }

      if (!ok) {
         throw new IntegrityException("Some list element(s) do not have the correct \"_owner\" field");
      }
   
   } 

   /** Returns a string representation of the list. */
   public String toString() {
      String result = "(";
      int count = 0; 
      for (Node n=getFirst(); n != null; n=n.getNext(), count++) {
         if (count != 0) {
            result += ' ';
         }
         result += n.current;
      }
      result += ')';
      return result;
   }

};

