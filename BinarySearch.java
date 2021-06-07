
//What role should binary search play in a truly object-oriented program?



import java.util.Scanner;
class SortedList
{
	private int arr[];
  public static void main(String args[])
  {
    int c, first, last, middle, n, search, array[];
 
    Scanner in = new Scanner(System.in);
    System.out.println("Enter number of elements");
    n = in.nextInt(); 
    array = new int[n];
 
    System.out.println("Enter " + n + " integers in ascending order");
 
    for (c = 0; c < n; c++)
      array[c] = in.nextInt();
 
    System.out.println("Enter value to find");
    search = in.nextInt();
    in.close();
 
    SortedList sl = new SortedList(array);
    sl.binarySearch(search);

  }
  public SortedList() {
	  //create an empty list
  }
  public SortedList(int a[]) {
	  //fills arr with the items in a, ensuring they're sorted
  }
  public int binarySearch(int search) {
	    int first, last, middle, n, search;
	    first  = 0;
	    last   = n - 1;
	    middle = (first + last)/2;
	 
	    while( first <= last )
	    {
	      if ( array[middle] < search )
	        first = middle + 1;    
	      else if ( array[middle] == search ) 
	      {
	        System.out.println(search + " found at location " + middle + ".");
	        break;
	      }
	      else
	         last = middle - 1;
	 
	      middle = (first + last)/2;
	   }
	   if ( first > last )
	      System.out.println(search + " is not present in the list.\n");
  }
  
}
