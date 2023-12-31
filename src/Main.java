import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Вся работа с пользовательским вводом и выводом меню будет производиться в этом классе
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker(scanner);

        while(true) {
            printMenu();

            int i = scanner.nextInt();

            if (i==1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i==2) {
                stepTracker.changeStepGoal();
            } else if (i==3) {
                System.out.println("Введите номер месяца:");
                int month = scanner.nextInt();

                if (month < 1 || month > 12) {
                    System.out.println("Некорректный номер месяца");
                }
                stepTracker.printStatistic();

            } else if (i==4) {
                System.out.println("Пока!");
                scanner.close();
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за месяц");
        System.out.println("4 - Выйти из приложения");
        System.out.print("Выберите команду: ");
    }
}
