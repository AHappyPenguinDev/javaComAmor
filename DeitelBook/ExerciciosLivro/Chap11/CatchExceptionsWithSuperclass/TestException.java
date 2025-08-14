public class TestException  {
  public static void main(String[] args) {
    try{
      throw new ExceptionB("Exception B");
      
    }
    catch (ExceptionB e){
      System.out.printf("Exception B stack trace: ", e.printStackTrace());  
    }

    try{
      throw new ExceptionC("Exception C");
      
    }
    catch (ExceptionC e){
      System.out.printf("Exception C stack trace: ", e.printStackTrace());  
    }

  }
}
