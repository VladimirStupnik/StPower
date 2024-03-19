package program;

import model.Calculator;
import model.RomanNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int calculator = Calculator.calculator(sc.toString());
        System.out.println(calculator);*/
        String calculator = Calculator.calculator("dccc-dC");
        System.out.println(calculator);
        String xc = RomanNumber.arabicToRoman(888);
        System.out.println(xc);
    }
}
