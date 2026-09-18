public class PalindromeCheckerThreeApproaches {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    static boolean isPalindromeRecursiveHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        char[] reversed = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    static String label(boolean isPalindrome) {
        if (isPalindrome) {
            return "Palindrome";
        }
        return "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] samples = {"madam", "hello"};
        for (int i = 0; i < samples.length; i++) {
            String text = samples[i];
            System.out.println("Iterative: " + label(isPalindromeIterative(text))
                    + " | Recursive: " + label(isPalindromeRecursive(text))
                    + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
        }
    }
}
