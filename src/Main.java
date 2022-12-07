import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calc(String.valueOf(0));
    }
    public static String calc (String input){
        int res = 0;

        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        int[] arabian = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
                28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
                58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87,
                88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String expression = scan.nextLine();
        int i = 0;
        String[] exp = expression.split(" "); // разделение строки массива по символу "пробел"
        int[] operation = new int[2];
        String s1, s2, res2;
        res2 = "";
        int arab;
        boolean isRoman2 = false;
        boolean isRoman = false;
        boolean process = true;
        boolean showResult = true;

        if (exp.length > 3){
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
            process = false;
        }
        if (expression.length() < 5){
            System.out.println("Строка не является математической операцией");
            process = false;
        }
        //обработка первого числа
        if (process) {
            try {
                operation[0] = Integer.parseInt(exp[0]);
            } catch (NumberFormatException e) {
                try {

                    for (i = 0; i <= 99; i++) {

                        s1 = exp[0];
                        s2 = roman[i];

                        if (s1.equals(s2)) {
                            isRoman = true;
                            operation[0] = arabian[i];
                        }
                    }
                    if (!isRoman) {
                        System.out.println("Ошибка ввода");
                        process = false;
                    }
                } catch (NumberFormatException q) {
                    System.out.println("Ошибка ввода.");
                }
            }
        }
        //обработка второго числа
        if (process) {
            try
            {
                operation[1] = Integer.parseInt(exp[2]);
                if (isRoman)
                {
                    process = false;
                    System.out.println("Оба числа должны быть римскими ИЛИ арабскими");
                }
            }
            catch (NumberFormatException e)
            {
                try
                {
                    for (i = 0; i <= 99; i++)
                    {
                        s1 = exp[2];
                        s2 = roman[i];
                        if (s1.equals(s2))
                        {
                            operation[1] = arabian[i];
                            isRoman2 = true;
                        }
                    }
                    if (!isRoman2)
                    {
                        System.out.println("Ошибка ввода");
                        process = false;
                    }
                }
                catch (NumberFormatException q)
                {
//
                }
                if (!isRoman && isRoman2)
                {
                    System.out.println("Оба числа должны быть римскими ИЛИ арабскими");
                    process = false;
                }
            }
        }
        //основное тело
//
        if (process) {
            if (operation[0] >= 0 && operation[0] <= 10 && operation[1] >= 0 && operation[1] <= 10) {
                try {

                    switch (exp[1]) {
                        case "+":
                            res = operation[0] + operation[1];

                            //System.out.println("Результат: " + res);
                            break;
                        case "-":
                            res = operation[0] - operation[1];
                            //System.out.println("Результат: " + res);
                            break;
                        case "*":
                            res = operation[0] * operation[1];
                            //System.out.println("Результат: " + res);
                            break;
                        case "/":
                            if (operation[1] == 0) {
                                System.out.println("На ноль делить нельзя!");
                            } else {
                                res = operation[0] / operation[1];
                                int integralPart = (int) res; // удаление остатка от деления у переменной res
                                //System.out.println("Результат: " + res);
                            }
                            break;
                        default:
                            System.out.println("Ошибка. Неверное выражение.");
                    }
                    if (res < 1){

                        if(isRoman){
                            showResult = false;
                            System.out.println("Отрицательный результат не может быть выведен для римских цифр");
                        }
                    }
                    if (isRoman){
                        for (i = 0; i <= 99; i++) {


                            arab = arabian[i];

                            if (res == arab) {
                                res2 = roman[i];
                            }
                        }
                    } else {
                        res2 = String.valueOf(res);
                    }
                    if (showResult){
                        System.out.println("Результат: " + res2);
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ошибка. Недопустимое выражение. Пример выражения: а + b");
                }
            } else {
                System.out.println("Внимание! Необходимо вводить числа от 1 до 10");
            }
        }
        return res2;
    }

}