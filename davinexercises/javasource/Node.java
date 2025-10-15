package dlists;

/**
 * 
 * A class for representing the nodes of a doubly-linked list.
 * 
 * @author Davin Pearson
 * @see    List
 * @see    IsNodeObject
 * 
 */
public class Node {

   /* Underscores are used in this file to
    * emphasise package visibility.
    */
   Node _next;
   Node _prev;
   List _owner;

   public IsNodeObject current;

   /* Returns whether or not the current node is the first
    * element of the list.  Logically unnecessary, but
    * convenient.
    */
   //   public boolean isFirst() { return _prev == null; }
   /* Returns whether or not the current node is the last
    * element of the list.  Logically unnecessary, but
    * convenient.
    */
   //   public boolean isLast()  { return _next == null; }
   
   /**
    * Method for moving forwards through the list.
    *   @return The previous element on the list.
    *   @see #getPrev()
    */
   public Node getNext() {
      return _next;
   }
   /**
    * Method for moving backwards through the list.
    *   @return The next element on the list.
    *   @see #getNext()
    */
   public Node getPrev() {
      return _prev;
   }
   //    public Node cyclicNext() {
   //       if (_next != null) {
   //          return _next;
   //       }
   //       else {
   //          return _owner._first;
   //       }
   //    }
   //    public Node cyclicPrev() {
   //       if (_prev != null) {
   //          return _prev;
   //       }
   //       else {
   //          return _owner._last;
   //       }
   //    }

   /** Returns which list the current node belongs to. */
   public List getOwner() { return _owner; }

   /** Alias for {@link #addNext(dlists.IsNodeObject) addNext}. */
   public void add(IsNodeObject o) {
      addNext(o);
   }

   /** Adds a node after the current one. */
   public void addNext(IsNodeObject o) {
      Node n = new Node();
      
      n._owner = this._owner;
      n._prev  = this;
      n._next  = this._next;
      n.current= o;

      /* SYNC'ING WITH ADJACENTS: */
      
      if (n._prev != null) n._prev._next = n;
      if (n._next != null) n._next._prev = n;
      
      /* SYNC END: */
      
      if (n._owner._last == n._prev)
         n._owner._last = this;
      
   }

   /** Adds a node prior to the current one. */
   public void addPrev(IsNodeObject o) {
      Node n = new Node();

      n._owner  = this._owner;
      n._prev   = this._prev;
      n._next   = this;
      n.current = o;

      /* SYNC'ING WITH ADJACENTS: */

      if (n._prev != null) n._prev._next = n;
      if (n._next != null) n._next._prev = n;
   
      /* SYNC END: */
   
      if (n._owner._first == n._next)
         n._owner._first = this;

   }

   /** Removes the current element of the list.
    */
   public void remove() {
      if (_next != null) _next._prev = _prev;
      if (_prev != null) _prev._next = _next;
      
      //      ASSERT(_owner != null);
      
      if (_owner._first == this) {
         _owner._first =
            _owner._first._next;
      }
      
      if (_owner._last == this) {
         _owner._last =
            _owner._last._prev;              
      }
   }

   public String toString() {
      return current.toString();
   }
    
}
