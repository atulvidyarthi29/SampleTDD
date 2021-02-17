import java.util.HashSet;
import java.util.Set;

public class StringCalculator {

    static int count;

//    private ArrayList<String> split(String string, String delimiter) {
//        ArrayList<String> result = new ArrayList<>();
//        while (string.length() > 0) {
//            if (!string.contains(delimiter)) {
//                result.add(string);
//                break;
//            }
//            else {
//                int startIndex = string.indexOf(delimiter);
//                result.add(string.substring(0, startIndex));
//                string = string.substring(startIndex + delimiter.length());
//            }
//        }
//        return result;
//    }


    private String removeWildCardCharacters(String delimiter) {
        return delimiter.replaceAll("\\*", ",")
                .replaceAll("\\+", ",")
                .replaceAll("\\.", ",")
                .replaceAll("\\?", ",")
                .replaceAll("\\*", ",")
                .replaceAll(",+", ",");
    }

    private String[] processMultipleDelimiter(String str) {
        Set<String> delimiters = new HashSet<>();
        String i = str;

        while (i.contains("[")) {
            int startIndex = i.indexOf("[");
            int endIndex = i.indexOf("]");
            delimiters.add(i.substring(startIndex + 1, endIndex));
            i = i.substring(endIndex + 1);
        }

        str = str.substring(str.indexOf('\n') + 1);


        for (String delimiter : delimiters) {
            str = str.replaceAll(delimiter, ",");
        }

        return str.split(",+");
    }

    private String[] tokenize(String str) {
        str = removeWildCardCharacters(str);
        if (!str.startsWith("//")) {
            str = str.replaceAll("\n", ",");
            return str.split(",");
        }
        if (!str.substring(0, str.indexOf("\n")).contains("[")) {
            String newDelimiter = str.substring(2, 3);
            str = str.substring(str.indexOf("\n") + 1);
            str = str.replaceAll("\n", newDelimiter);
            return str.substring(str.indexOf("\n") + 1).split(newDelimiter);
        }
        return processMultipleDelimiter(str);
    }

    public int add(String str) throws Exception {
        count++;
        if (str.length() == 0) return 0;

        String[] numbers = tokenize(str);

        StringBuilder neg = new StringBuilder();
        for (String num : numbers)
            if (num.charAt(0) == '-') {
                neg.append(",").append("");
            }
        if (neg.length() > 0) throw new Exception("Negatives not allowed. Found " + neg);

        int sum = 0;
        for (String num : numbers) {
            int intValue = Integer.parseInt(num);
            sum += (intValue > 1000) ? 0 : intValue;
        }

        return sum;
    }

    public int getCalledCount() {
        return count;
    }
}
