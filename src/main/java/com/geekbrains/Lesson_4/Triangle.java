package com.geekbrains.Lesson_4;

public class Triangle {
    public static Double TriangleF(int a, int b, int c) {

        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        Integer p = (a + b + c) / 2;
        if (p - a < 0 || p - b < 0 || p - c < 0) {
            System.out.println("Треугольник не существует");
        } else if (p == 0 || p - a == 0 || p - b == 0 || p - c == 0) {
            System.out.println("Вырожденный в отрезок или точку треугольник не имеет площади");
        } else {
            System.out.println(" - " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));
            Double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
        return null;
    }
}


