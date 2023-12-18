public class SumOfNaturalNos {
    public static void main(String[] args) {

        sumOfNaturalNumbersFormula(5);
        sumOfNaturalNumbers(5);
        System.out.println(sumOfNaturalNumbersRecursion(5));
    }

    public static void sumOfNaturalNumbersFormula(int size) {
       /* int sum = 0;
        for (int i = 1; i <= size; i++) {
            sum = sum + i;
        }
        System.out.println(sum);*/
        System.out.println(size * (size + 1) / 2);
    }

    public static void sumOfNaturalNumbers(int size) {
        int sum = 0;
        for (int i = 1; i <= size; i++) {
            sum = sum + i;
        }
        System.out.println(sum);

    }

    public static int sumOfNaturalNumbersRecursion(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumOfNaturalNumbersRecursion(n - 1);
    }
}