public class StringCalculator {
    public int add(String str) throws Exception {
        if (str.length() == 0) return 0;

        String delimiter = ",";
        if (str.startsWith("//")) {
            delimiter = str.substring(2, str.indexOf('\n'));
            str = str.substring(str.indexOf('\n') + 1);
        }

        str = str.replace("\n", delimiter);
        int sum = 0;
        String[] numbers = str.split(delimiter);

        StringBuilder neg = new StringBuilder();
        for (String num : numbers)
            if (num.charAt(0) == '-') {
                neg.append(",").append("");
            }
        if (neg.length() > 0) throw new Exception("Negatives not allowed. Found " + neg);

        for (String num : numbers)
            sum += Integer.parseInt(num);

        return sum;
    }
}
