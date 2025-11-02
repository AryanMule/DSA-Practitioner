
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        // Step 1: Filter only alphanumeric and lowercase
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        // Step 2: Compare with reverse
        String str = cleaned.toString();
        String rev = cleaned.reverse().toString();
        return str.equals(rev);
    }

    public static boolean isPalindromeTwoPointer(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            // Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                // Compare lowercase characters
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                // ✅ Move both pointers inward after valid comparison
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindromeTwoPointer(s));

    }

}
