import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class EulersNumber {
  private static double factorial(double num) {
    if(num <= 1.00) {
      return 1.00;
    }
    double recursiveResult = num * factorial(num - 1); // calc factorial and increase indent by one
    //System.out.printf("%nFactorial(%.2f) = %.2f", num, recursiveResult);
    return recursiveResult;
  }

  public static BigDecimal getEulerNumber(int numPrecision) {
    List<BigDecimal> factorialList = new ArrayList<>();
    System.out.print("e = ");
    for(int i = 0; i <= numPrecision; i++) {
      BigDecimal facNum = new BigDecimal(factorial(i));
      factorialList.add(facNum);
      System.out.printf("1/%d! %s ", i, (i==numPrecision?"":"+")); // this is so the plus sign wont be added at the end of the string
    }
    
    return factorialList.stream()
      .map(fac -> BigDecimal.ONE.divide(fac, 10, RoundingMode.HALF_UP))
      .reduce(BigDecimal.ZERO, BigDecimal::add);
      //.reduce(fac -> fac.add(fac));
  }

  public static void main(String[] args) {
    int precision = 10; //More precision = more factorials calculated to use in getEulerNumber
    System.out.printf("%nEuler's number: %s%n", getEulerNumber(precision));
  }
}


// import java.util.ArrayList;
// import java.util.List;
//
// public class EulersNumber {
//   private static double factorial(double num) {
//     if(num <= 1.00) {
//       return 1.00;
//     }
//     double recursiveResult = num * factorial(num - 1); // calc factorial and increase indent by one
//     //System.out.printf("%nFactorial(%.2f) = %.2f", num, recursiveResult);
//     return recursiveResult;
//   }
//
//   public static double getEulerNumber(int numPrecision) {
//     List<Double> factorialList = new ArrayList<>();
//     System.out.print("e = ");
//     for (int i = 0; i <= numPrecision; i++) {
//       BigDeciaml facNum = factorial(i);
//       System.out.printf("1/%d! %s ", i, (i==numPrecision?"":"+")); // this is so the plus sign wont be added at the end of the string
//       factorialList.add(facNum);
//     }
//     return factorialList.stream()
//       .mapToDouble(fac -> 1/fac)
//       .sum();
//   }
//
//   public static void main(String[] args) {
//     int precision = 100;
//     System.out.printf("%nEuler's number: %.100f%n", getEulerNumber(precision));
//   }
// }
