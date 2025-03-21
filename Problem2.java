/* Giselle Muriel 
 * Problem2.java - searches the array recursively for the value x and return the index of the element if it’s found
 */
 import java.util.Arrays;

 public class Problem2
 {
    public static <E extends Comparable<E>>
        int binarySearch(E[] a, E x)
        {
            return binarySearchTwo(a, 0, a.length - 1, x);
        }

        private static <E extends Comparable<E>> int binarySearchTwo(E[] a, int start, int stop, E x)
        {
            while(start <= stop)
            {
                int mid = (start + stop) / 2;

                int compareResult = a[mid].compareTo(x);
                if(compareResult == 0)
                {
                    return mid;
                }
                else if(compareResult > 0)
                {
                    //if the value exists, it's in the lower half
                    stop = mid -1;
                }
                else
                {
                    //if the value exists, it's in the upper half
                    start = mid + 1;
                }
            }

            return -1;
        }

    public static void main(String[] args)
    {
        String[] state = {"florida", "texas", "arizona", "california", "iowa"};
        Arrays.sort(state);

        System.out.println(binarySearch(state, "california"));
        System.out.println(binarySearch(state, "idaho"));
        System.out.println(binarySearch(state, "texas"));
    }
 }
