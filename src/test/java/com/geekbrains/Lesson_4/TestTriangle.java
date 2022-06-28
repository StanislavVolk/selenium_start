package com.geekbrains.Lesson_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTriangle {
    Logger logger = LoggerFactory.getLogger("TestTriangle");


    @Test
    @DisplayName("Тест 1: проверка формулы")
    void TriangleTest1() {
        logger.info("Тест 1: проверка формулы");
        assertFalse(Triangle.TriangleF(3, 6, 7) == 0);
        logger.info("\tТест пройден!");
    }



    @ParameterizedTest
    @CsvSource({"3,6,7,8.94427190999916", "-3,-6,-7,8.94427190999916", "3,-6,7,8.94427190999916", "7,6,7,18.973665961010276"})
    @DisplayName("Тест 2: проверка корректности вычисления площади на существующих треугольниках")
    void TriangleTest2(int a, int b, int c, double d) {
        logger.info("Тест 2: проверка на существующих треугольниках");
        logger.info("\tВходящие параметры - (a,b,c) - " + a + ", " + b + ", " + c);
        assertEquals(Triangle.TriangleF(a, b, c), d);
        logger.info("\tТест пройден!");

        System.out.println("Для GITа");
    }



}
