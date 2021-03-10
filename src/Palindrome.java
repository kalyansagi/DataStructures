public class Palindrome {

    public static void main(String args[]) {

        System.out.println("Is nan a palidrome ? " + isPalindrome("nan"));

    }

    public static boolean isPalindrome(String input) {

        if (input.length() < 1)
            return true;

        else if (input.charAt(0) != input.charAt(input.length() - 1))
            return false;

        else
            return isPalindrome(input.substring(1, input.length() - 2));
    }
}
