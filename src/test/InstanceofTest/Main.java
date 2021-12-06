package InstanceofTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            SonClassOne sonClass1 = new SonClassOne();
            FatherClass fatherClass = new FatherClass();
            FatherClass polymorphism;
            if (new Scanner(System.in).nextInt() == 1) {
                polymorphism = new SonClassOne();
            } else {
                polymorphism = new SonClassTwo();
            }
            System.out.println(sonClass1 instanceof FatherClass);       // true
            System.out.println(fatherClass instanceof SonClassOne);     // false

            System.out.println(polymorphism instanceof FatherClass);   // true
            System.out.println(polymorphism instanceof SonClassOne);   // 输入 1 时为 true
            System.out.println(polymorphism instanceof SonClassTwo);   // 输入 2 时为 true
        }
    }
}
