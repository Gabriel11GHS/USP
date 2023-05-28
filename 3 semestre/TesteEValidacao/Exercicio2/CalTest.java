/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

/**
 *
 * @author gabriel santos
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CalTest {

    @Test
    public void testFirstOfMonth() {
        Cal cal = new Cal();

        // Testando o primeiro mês do ano
        assertEquals(1, cal.firstOfMonth(1, 2023));
        // Testando um mês intermediário
        assertEquals(2, cal.firstOfMonth(6, 2023));
        // Testando o último mês do ano
        assertEquals(6, cal.firstOfMonth(12, 2023));
    }

    @Test
    public void testNumberOfDays() {
        Cal cal = new Cal();

        // Testando um mês com 31 dias
        assertEquals(31, cal.numberOfDays(1, 2023));
        // Testando um mês com 30 dias
        assertEquals(30, cal.numberOfDays(4, 2023));
        // Testando o mês de fevereiro em um ano não bissexto
        assertEquals(28, cal.numberOfDays(2, 2023));
        // Testando o mês de fevereiro em um ano bissexto
        assertEquals(29, cal.numberOfDays(2, 2024));
        // Testando o mês de setembro do ano de 1752
        assertEquals(19, cal.numberOfDays(9, 1752));
    }

    @Test
    public void testIsLeap() {
        Cal cal = new Cal();

        // Testando um ano não bissexto
        assertFalse(cal.isLeap(2023));
        // Testando um ano bissexto
        assertTrue(cal.isLeap(2024));
        // Testando o ano 1752 (ano do ajuste no calendário gregoriano)
        assertFalse(cal.isLeap(1752));
    }

    @Test
    public void testCal() {
        Cal cal = new Cal();

        // Testando um mês com 31 dias
        String expected = "         1  2  3  4\n 5  6  7  8  9 10 11\n12 13 14 15 16 17 18\n19 20 21 22 23 24 25\n26 27 28 29 30 31";
        assertEquals(expected, cal.cal(2, 31));
        // Testando um mês com 30 dias
        expected = "         1  2  3  4\n 5  6  7  8  9 10 11\n12 13 14 15 16 17 18\n19 20 21 22 23 24 25\n26 27 28 29 30";
        assertEquals(expected, cal.cal(3, 30));
        // Testando o mês de fevereiro em um ano não bissexto
        expected = "            1  2  3\n 4  5  6  7  8  9 10\n11 12 13 14 15 16 17\n18 19 20 21 22 23 24\n25 26 27 28";
        assertEquals(expected, cal.cal(5, 28));
        // Testando o mês de fevereiro em um ano bissexto
        expected = "               1  2\n 3  4  5  6  7  8  9\n10 11 12 13 14 15 16\n17 18 19 20 21 22 23\n24 25 26 27 28 29";
        assertEquals(expected, cal.cal(6, 29));
        // Testando o mês de setembro do ano de 1752
        expected = "                   1\n 2 14 15 16 17 18 19\n20 21 22 23 24 25 26\n27 28 29 30";
        assertEquals(expected, cal.cal(6, 19));
    }
}
