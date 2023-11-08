import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();
    MonthData monthData = new MonthData();

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Некорректный номер месяца");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();

        if (day < 1 || day > 30) {
            System.out.println("Некорректный номер дня");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Некорректное количество шагов");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;

        System.out.println("Данные сохранены");
    }

    void changeStepGoal() {
        System.out.println("Сколько шагов в день вы готовы пройти?");

        int newGoal = scanner.nextInt();

        if (newGoal <= 0) {
            System.out.println("Некорректное значение цели");
            return;
        }

        goalByStepsPerDay = newGoal;
        System.out.println("Цель изменена");
    }

    public void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Некорректный номер месяца");
            return;
        }

        System.out.println("Количество пройденных шагов по дням:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов: " + (monthData.sumStepsFromMonth() / monthData.maxSteps()));
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(goalByStepsPerDay));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(goalByStepsPerDay));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}