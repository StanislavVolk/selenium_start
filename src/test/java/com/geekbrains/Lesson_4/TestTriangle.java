package com.geekbrains.Lesson_4;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;

public class TestTriangle {
    @Test
    void TriangleTest1() {
        assertFalse(Triangle.TriangleF(3, 6, 7) == 0);
        System.out.println("Тест пройден");
    }


}
