//I thought this would be harder, but basically, you just get 
//a pointer going from the left to the right and one from right to left
//then, you move both toward the center of the char array and if the left side
//is greater than the right side, that means you reversed the string

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayBackward {
  public static char[] stringReverse(char[] array,int rightIndex, int leftIndex) {
    if(leftIndex > rightIndex)
      return array;
    
    char temp = array[leftIndex];
    array[leftIndex] = array[rightIndex];
    array[rightIndex] = temp;
    System.out.printf("%nLeft index: %d | Right Index: %d", leftIndex,rightIndex);
    System.out.printf("%nString: %s%n", Arrays.toString(array));
    return stringReverse(array, rightIndex-1, leftIndex+1);
  }

  public static void main(String[] args) {
    String sentence = "watermelon?";
    char[] array = sentence.toCharArray();
    System.out.printf("Original array: %s%n", Arrays.toString(array));
    
    char[] reversedArray = stringReverse(array, array.length-1, 0);
    String reversedSentence = new String(reversedArray);
    
    System.out.printf("%nReversed string: %s%n", reversedSentence);
  }
}
