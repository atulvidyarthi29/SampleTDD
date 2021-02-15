public class StringCalculator {
    public int add(String str) {
        if (str.length() == 0) return 0;

        int index = str.indexOf(',');
        if (index == -1) return Integer.parseInt(str);

        int num1 = Integer.parseInt(str.substring(0, index));
        int num2 = Integer.parseInt(str.substring(index + 1));
        return num1 + num2;
    }
}
