package model;

import java.util.TreeMap;

public class Calculator {

    private String input;

    public static String calculator(String input) {
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int res = 0;
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
        }
        String s = input.toUpperCase();
        String[] data = s.split(regexActions[actionIndex]);
        if (Calculator.isRoman(data[0]) == Calculator.isRoman(data[1])) {
            if (Character.isLetter(data[0].charAt(0))) {
                int a = RomanNumber.romanToArabic(data[0]);
                int b = RomanNumber.romanToArabic(data[1]);
                switch (actions[actionIndex]) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                }
                return RomanNumber.arabicToRoman(res);
            } else if (Character.isDigit(data[0].charAt(0))) {
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                switch (actions[actionIndex]) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                }
            }
            return String.valueOf(res);
        } else
            return "The numbers must be of the same format";
    }

    public static boolean isRoman(String number) {
        TreeMap<Character, Integer> romanArabic = new TreeMap<>();
        romanArabic.put('I', RomanNumber.I.getValue());
        romanArabic.put('V', RomanNumber.V.getValue());
        romanArabic.put('X', RomanNumber.X.getValue());
        romanArabic.put('L', RomanNumber.L.getValue());
        romanArabic.put('C', RomanNumber.C.getValue());
        romanArabic.put('D', RomanNumber.D.getValue());
        romanArabic.put('M', RomanNumber.M.getValue());
        return romanArabic.containsKey(number.charAt(0));
    }
}



/*if (Character.isDigit(input.charAt(0))) {
            int digit = Character.digit(input.charAt(0), 10);
            a += digit;
            if (input.charAt(1) == '-') {
                if (Character.isDigit(input.charAt(2))) {
                    int digit2 = Character.digit(input.charAt(2), 10);
                    b += digit2;
                    res = a - b;
                }
            } else if (input.charAt(1) == '+') {
                if (Character.isDigit(input.charAt(2))) {
                    int digit2 = Character.digit(input.charAt(2), 10);
                    b += digit2;
                    res = a + b;
                }
            } else if (input.charAt(1) == '/') {
                if (Character.isDigit(input.charAt(2))) {
                    int digit2 = Character.digit(input.charAt(2), 10);
                    b += digit2;
                    res = a / b;
                }
            } else if (input.charAt(1) == '*') {
                if (Character.isDigit(input.charAt(2))) {
                    int digit2 = Character.digit(input.charAt(2), 10);
                    b += digit2;
                    res = a * b;
                }
            }
        }
        return res;
    }*/
