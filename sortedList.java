
import java.util.Scanner;

public class sortedList {
    public static int c, first, last, middle, n, search;
    public static int array[];

    //Functions
    public sortedList() {
        c = 0;
        first = 0;
        last = 0;
        middle = 0;
        search = 0;
        n = 0;
    }

    public sortedList(int a[]) {
        c = 0;
        first = 0;
        last = 0;
        middle = 0;
        search = 0;
        n = a.length;
        array = a;
    }

    public void insert(int pos, int val, sortedList b, int p, int r)
    {
        int a[] = new int[n+1];
        for(int i = 0; i < n; i++)
        {
            a[i] = array[i];
        }

        for(int i = (n-1); i >= (pos-1); i--)
        {
            a[i+1] = a[i];
        }
        a[pos-1] = val;

        quicksort(a, p, r);

        for (int i = 0; i < a.length; i++)
            System.out.println("Element at index " + i +
                    " : "+ a[i]);
    }


    public static int partition(int input[], int p, int r) {
        int pivot = input[r];

        while (p < r) {
            while (input[p] < pivot) {
                p++;
            }
            while (input[r] > pivot) {
                r--;
            }
            if (input[p] == input[r]) {
                p++;
            } else if (p < r) {
                int tmp = input[p];
                input[p] = input[r];
                input[r] = tmp;
            }
        }
        return r;
    }

    public static void quicksort(int input[], int p, int r) {
        if (p < r) {
            int j = partition(input, p, r);
            quicksort(input, p, j - 1);
            quicksort(input, j + 1, r);
        }
    }

    public static void main(String args[]) {
        int arr[] = {1,3,4,6,7};
        sortedList a = new sortedList(arr);

        a.insert(5, 8, a, 0, 5);

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

        first = 0;
        last = n - 1;
        middle = (first + last) / 2;

        while (first <= last) {
            if (array[middle] < search)
                first = middle + 1;
            else if (array[middle] == search) {
                System.out.println(search + " found at location " + middle + ".");
                break;
            } else
                last = middle - 1;

            middle = (first + last) / 2;
        }
        if (first > last)
            System.out.println(search + " is not present in the list.\n");
    }
}

