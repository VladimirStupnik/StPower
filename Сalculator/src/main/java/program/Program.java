package program;

import model.Calculator;
import model.RomanNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        /*String calculator = Calculator.calculator("10/5");
        System.out.println(calculator);
        int i = RomanNumber.romanToArabic("XII");
        System.out.println(i);
        String s = RomanNumber.arabicToRoman(322);
        System.out.println(s);*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String res = sc.nextLine();
        String calculatorRoman = Calculator.calculator(res);
        System.out.println(calculatorRoman);
    }
}
