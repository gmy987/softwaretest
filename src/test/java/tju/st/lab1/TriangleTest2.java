package tju.st.lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gmy on 16/5/3.
 */
public class TriangleTest2 {

    Triangle triangle;

    @Before
    public void setUp() throws Exception {
        triangle = new Triangle();
    }

    @Test
    public void testGetTriangleType() throws Exception {
        assertEquals("NotTriangle", triangle.getTriangleType(1, 2, 3));
        assertEquals("Equilateral", triangle.getTriangleType(3, 3, 3));
        assertEquals("Isosceles", triangle.getTriangleType(2, 7, 7));
        assertEquals("Scalene", triangle.getTriangleType(3, 9, 7));
    }
}