public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;
        char originalMismatch = 0;
        char typedMismatch = 0;
        int length = original.length();
        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;
                originalMismatch = original.charAt(i);
                typedMismatch = typed.charAt(i);
            }
        }
        double accuracy = (matched * 100.0) / length;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, length, accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + firstMismatch
                    + " ('" + originalMismatch + "' vs '" + typedMismatch + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
