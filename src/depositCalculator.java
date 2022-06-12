import java.util.Scanner;

public class depositCalculator {

    double calculateComplexPercent(double a, double y, int d) { // Переменные из одного символа запутают. Лучше словом.
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return summ(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return summ(amount + amount * yearRate * period, 2);
    }

    double summ(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale)/ Scale;
    }


    void calculateResult() {

        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, " + // Круто что по строкам разнесено, так все быстро и легко читается.
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else {
            if (action == 2) {
                out = calculateComplexPercent(amount, 0.06, period);
            }
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new depositCalculator().calculateResult();
    }


}
