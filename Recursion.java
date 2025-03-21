/**
 * Giselle Muriel
 * Programming Assignment 2 - Recursion exercises
 *
 */
public class Recursion
{
    /**
     * Returns the value of x * y, computed via recursive addition.
     * x is added y times. Both x and y are non-negative.
     * @param x non-negative integer multiplicand 1
     * @param y non-negative integer multiplicand 2
     * @return x * y
     */
    public static int recursiveMultiplication(int x, int y)
    {
        //if any of the factors are less than or equal to 0
        if(x <= 0 || y <= 0)
        {
            return 0;
        }

        //returns factor x + ... depending on how many times it takes for y to reach 0
        return x + recursiveMultiplication(x, y - 1);
    }

/******************************************************************************/
    /**
     * Reverses a string via recursion.
     * @param s the non-null string to reverse
     * @return a new string with the characters in reverse order
     */
    public static String reverse(String s)
    {
        //if the String is null or no letter
        if(s == null || s.length() == 0)
        {
            //return back the same String, or lack thereof, given
            return s;
        }

        //assembling string by separating first letter by rest of word using substring
        return reverse(s.substring(1)) + s.charAt(0);
    }
/******************************************************************************/
    private static int maxHelper(int[] array, int index, int max)
    {
        //index in max() is 0 so if array.length is 0
        if(index == array.length)
        {
            //max is Integer.MIN_VALUE
            return max;
        }
        else if(array[index] > max)
        {
            //goes through array checking if value in an index is greater than the value before it
            //if so the max is that new greater value
            max = array[index];
        }

        //returns max based on array, going up by index to compare each value
        return maxHelper(array, index + 1, max);
    }

    /**
     * Returns the maximum value in the array.
     * Uses a helper method to do the recursion.
     * @param array the array of integers to traverse
     * @return the maximum value in the array
     */
    public static int max(int[] array)
    {
        return maxHelper(array, 0, Integer.MIN_VALUE);
    }

/******************************************************************************/
    /**
     * Returns whether or not a string is a palindrome, a string that is
     * the same both forward and backward.
     * @param s the string to process
     * @return a boolean indicating if the string is a palindrome
     */
    public static boolean isPalindrome(String s)
    {
        //if there is no letter or only one
        if(s.length() == 0 || s.length() == 1)
        {
            //it's automatically considered a palindrome
            return true;
        }

        //if the first character is the same as the last character
        if(s.charAt(0) == s.charAt(s.length() - 1))
        {
            //shorten your range by comparing the second char and the last char
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        return false;
    }

/******************************************************************************/
    private static boolean memberHelper(int key, int[] array, int index)
    {
        //index in isMember() is 0 so if array.length is 0
        if(index == array.length)
        {
            //there can be no key present
            return false;
        }

        //if the number in the array isn't equal to the key
        if(array[index] != key)
        {
            //increase the index and go through the array to search for the key
            return memberHelper(key, array, index + 1);
        }

        return true;
    }

    /**
     * Returns whether or not the integer key is in the array of integers.
     * Uses a helper method to do the recursion.
     * @param key the value to seek
     * @param array the array to traverse
     * @return a boolean indicating if the key is found in the array
     */
    public static boolean isMember(int key, int[] array)
    {
        return memberHelper(key, array, 0);
    }

/******************************************************************************/
    /**
     * Returns a new string where identical chars that are adjacent
     * in the original string are separated from each other by a tilde '~'.
     * @param s the string to process
     * @return a new string where identical adjacent characters are separated
     * by a tilde
     */
    public static String separateIdentical(String s)
    {
        //if there is no letter or only one
        if(s.equals("") || s.length() == 1)
        {
            //return back the string unchanged
            return s;
        }

        //if the first char is equal to the second one
        if(s.charAt(0) == s.charAt(1))
        {
            //return that char with a ~ between it and the rest of the word
            return s.charAt(0) + "~" + separateIdentical(s.substring(1));
        }

        //returns the first char followed by the rest of the word including any added ~
        return s.charAt(0) + separateIdentical(s.substring(1));
    }
}
