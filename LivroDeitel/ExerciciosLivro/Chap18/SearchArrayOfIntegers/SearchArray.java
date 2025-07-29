public class SearchArray {
  public static int searchArray(int[] array, int key, int index) {
    if(index >= array.length)
      return -1;

    if(array[index]== key)
      return key;
    
    return searchArray(array, key, index+1);
  }

  public static void main(String[] args) {
    int[] array = {1,2,3,4,5,6,7,8};
    int element = 9;
    int result = searchArray(array, element,0);
    System.out.printf("Element %s, at index (%d)%n", result>=0?"found":"not found", result); 
  }
}
