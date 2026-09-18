public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        StringBuilder formatted = new StringBuilder();
        formatted.append("[");
        formatted.append(reference.substring(0, 3));
        formatted.append("] DATE: ");
        formatted.append(reference.substring(3, 5));
        formatted.append("/");
        formatted.append(reference.substring(5, 7));
        formatted.append("/");
        formatted.append(reference.substring(7, 9));
        formatted.append(" | SEQ: ");
        formatted.append(reference.substring(9));
        return formatted.toString();
    }

    public static void main(String[] args) {
        String first = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(first));
        String second = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(second));
    }
}
