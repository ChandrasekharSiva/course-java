public class Iffy {
   private int anIntProp = 42;
   public static void main(String[] args) {
      Iffy me = new Iffy();
      me.callSomeMethods();
   }

   public void callSomeMethods() {
      // add statements here to exercise the other methods ...
   }

   /**
    * Print out a warning if the value is negative
    * otherwise don't do anything.
    */
   public void warnIfNegative(int theValue) {
      if(theValue < 0);
      System.out.println("Caution - negative value given (" + theValue + ")");
   }
  
   /**
    * Print out a warning if the value of anIntProp is negative
    * and also set the value to zero.
    * Otherwise don't do anything.
    */
   public void resetIfNegative() {
      if(anIntProp < 0)
         System.out.println("Caution - negative value given (" + anIntProp + ")");
      anIntProp = 0;
   }

   /**
    * return true if value is between upperBound and LowerBound
    * (or equal to either bound) otherwise return false.
    */
   // public boolean isInRange(int value, int upperBound, int lowerBound) {
   //  if(lowerBound <= value <= upperBound )
   //    return true;
   //  else
   //    return false;
   //}

   //public boolean isInRangeIfLess(int value, int upperBound, int lowerBound) {
   //  what goes here?
   //}
}
