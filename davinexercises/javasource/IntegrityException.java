package dlists;

public class IntegrityException extends Throwable {
   private String desc;
   public IntegrityException(String aDesc) {
      desc = aDesc;
   }
   public String toString() {
      return ("List integrity check failed in package dlists." +
              "  reason = " + desc);
   }
}
