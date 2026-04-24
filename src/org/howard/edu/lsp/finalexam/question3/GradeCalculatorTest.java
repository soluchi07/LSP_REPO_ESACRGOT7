package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    private final GradeCalculator calc = new GradeCalculator();

    @Test
    public void testAverageWithTypicalScores() {
        assertEquals(80.0, calc.average(90, 80, 70), 0.001);
    }

    @Test
    public void testLetterGradeA() {
        assertEquals("A", calc.letterGrade(95.0));
    }

    @Test
    public void testIsPassingWithPassingAverage() {
        assertTrue(calc.isPassing(75.0));
    }

    @Test
    public void testBoundaryAllZeroScores() {
        assertEquals(0.0, calc.average(0, 0, 0), 0.001);
    }

    @Test
    public void testBoundaryAllHundredScores() {
        assertEquals(100.0, calc.average(100, 100, 100), 0.001);
    }

    @Test
    public void testExceptionNegativeScore() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 80, 70));
    }

    @Test
    public void testExceptionScoreAboveOneHundred() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(101, 80, 70));
    }
}
