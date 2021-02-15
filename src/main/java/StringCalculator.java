public class StringCalculator {
    public int add(String str) {
        str = str.replace("\n", ",");
        if (str.length() == 0) return 0;

        int sum = 0;
        String[] numbers = str.split(",");
        for (String num : numbers)
            sum += Integer.parseInt(num);

        return sum;
    }
}
