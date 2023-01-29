package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите пример:");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }


    public static String calc(String input) {
        String res;

        int result, a, b;
        String[] line = input.split(" ");

        if (line.length != 3)
            throw new NumberFormatException("Пример не удовлетворяет условия, попробуйте ввести через пробел два операнда и один оператор(+,-,*,/)");
        romanException(line[0], line[2]);
        if (!compare(line[0], line[2])) {
            throw new IllegalArgumentException("Вы используете одновременно разные системы счисления");
        }
        switch (line[1]) {
            case "+":
            case "-":
            case "*":
            case "/":
                break;
            default:
                throw new IllegalArgumentException("Арифметическая операция не соответствует условию");
        }

        try {
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[2]);
            if (a < 1 || a > 10 || b < 1 || b > 10)
                throw new IllegalArgumentException();
            result = calculateResult(a, line[1], b);
            res = String.valueOf(result);
        } catch (NumberFormatException e) {
            a = Roman.valueOf(line[0]).getArab();
            b = Roman.valueOf(line[2]).getArab();
            result = calculateResult(a, line[1], b);
            if (result < 1) {
                throw new NumberFormatException("В римскй системе счисления нет отрицательных чисел");
            }
            res = convertNumToRoman(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неподходящее число, попробуйте ввести арабские или римские числа от 1 до 10");

        }
        return res;
    }


    private static String convertNumToRoman(int arab){
        String[] roman = {"NONE","I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX",
                "XC","XCI","XII","XCIII","XCIV","XCV","XCVI","XVII","XCVIII","ХХIХ","C"
        };
        return roman[arab];
    }


    private static boolean compare(String a, String b){
        try {
            Integer.parseInt(a);
            try {
                Integer.parseInt(b);
                return true;
            } catch (NumberFormatException exe){
                return false;
            }
        } catch (NumberFormatException e){
            try {
                Integer.parseInt(b);
                return false;
            } catch (NumberFormatException ex){
                return true;
            }

        }
    }


    private static boolean romanException(String a,String b){
        try {
            Integer.parseInt(a);
            try {
                Integer.parseInt(b);
                return true;
            } catch (IllegalArgumentException exc){
                try {
                    Roman.valueOf(b);
                    return true;
                } catch (NumberFormatException exce){
                    return false;
                }
            }
        } catch (IllegalArgumentException e){
            try {
                Roman.valueOf(a);
                try {
                    Integer.parseInt(b);
                    return true;
                } catch (IllegalArgumentException excep){
                    try {
                        Roman.valueOf(b);
                        return true;
                    } catch (NumberFormatException except){
                        return false;
                    }
                }
            } catch (IllegalArgumentException ex){
                throw new IllegalArgumentException("Неизвестное число, попробуйте ввести целые арабские или римские числа");
            }
        }
    }


    private static int calculateResult(int a, String operation, int b) throws NumberFormatException {
        switch (operation){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new NumberFormatException("Арифметическая операция не соответствует условию");
        }
    }
}
