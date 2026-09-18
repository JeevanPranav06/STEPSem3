public class LibraryISBNNormalizerValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisherCode + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        StringBuilder formatted = new StringBuilder();
        formatted.append("[");
        formatted.append(code.substring(0, 3));
        formatted.append("] YEAR: ");
        formatted.append(code.substring(3, 7));
        formatted.append(" | CATALOG: ");
        formatted.append(code.substring(7));
        return formatted.toString();
    }

    public static void main(String[] args) {
        String first = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(first));
        String second = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(second));
    }
}
