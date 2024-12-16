package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculaterTest {

    private Calculater calc;

    @BeforeEach
    void setUp() {
        calc = new Calculater();
        System.out.println("Инициализация перед тестом");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершение теста");
    }

    @Test
    @DisplayName("Тест для поиска слова с наибольшим 'И'")
    void testFindWordWithMostI() {
        assertTimeout(Duration.ofMillis(100), () -> {
            String sentence = "и подойти или Иван";
            String result = calc.findWordWithMostI(sentence);
            assertEquals("или", result, "Слово с наибольшим  букв 'И' у 'или'");
        });
    }

    @Disabled("ликвидирован")
    @Test
    void testFindWordWithMostI_nullString() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.findWordWithMostI(null);
        });
    }


    @Test
    @DisplayName("Тест для суммы значений по диагоналям")
    void testFindMaxDiagonalSum() {
        int[][] matrix = {
                {2, 2, 8},
                {4, 6, 6},
                {7, 5, 2}
        };
        int result = calc.findMaxDiagonalSum(matrix);
        assertEquals(21, result, "Максимальная сумма не");
    }

    @ParameterizedTest
    @CsvSource({
            "Я док, ЯД",
            "Писят два, ПД",
            "Тест, Т"
    })
    @DisplayName("Тест для получения первых букв в верхнем регистре")
    void testGetFirstLettersInUpperCaseCyrillic(String sentence, String expected) {
        String result = calc.getFirstLettersInUpperCase(sentence);
        assertEquals(expected, result, "Первый символ каждого слова должен быть в верхнем регистре");
    }













    @Test
    @DisplayName("Тест вычитания")
    void subtract() {
        int result = calc.subtract(5, 2);
        assertEquals(3, result, "5 - 2 должно быть равно 3");
    }

    @Test
    @DisplayName("Тест умножения со временем")
    void multiply() {
        assertTimeout(Duration.ofMillis(100), () -> {
            int result = calc.multiply(6, 2);
            assertEquals(12, result, "6 * 2 должно быть равно 12");
        });
    }

    @Test
    @DisplayName("Тест деления на ноль")
    void divide() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0), "Деление на ноль должно выбрасывать исключение");
    }
}