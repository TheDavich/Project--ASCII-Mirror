package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input the file path:");
        String path = scanner.nextLine();

        try{
            File animal = new File(path);
            Scanner fileScanner = new Scanner(animal);
            ArrayList<String> Lines = new ArrayList<>();

            while (fileScanner.hasNext()) {
                Lines.add(fileScanner.nextLine());
            }

            int max = 0;

            for(String s : Lines) {
                if(s.length() > max) {
                    max = s.length();
                }
            }

            int i = 0;
            while (i < Lines.size()) {
                if(isLess(Lines.get(i), max)) {
                    while(isLess(Lines.get(i), max)) {
                        Lines.set(i, Lines.get(i) + " ");
                    }
                }
                i++;
            }

            printMirror(Lines);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static void printMirror(ArrayList<String> a) {
        for(String s : a) {
            String reverse = "";
            for(int i = s.length() - 1; i >= 0; i--) {
                reverse += reverse(s.charAt(i));
            }

            System.out.println(s + " | " + reverse);
        }
    }

    private static boolean isLess(String s, int max) {return s.length() < max;}

    private static char reverse(char c) {
        return switch (c) {
            case '/' -> '\\';
            case '\\' -> '/';
            case '(' -> ')';
            case ')' -> '(';
            case '[' -> ']';
            case ']' -> '[';
            case '{' -> '}';
            case '}' -> '{';
            case '<' -> '>';
            case '>' -> '<';
            default -> c;
        };
    }
}