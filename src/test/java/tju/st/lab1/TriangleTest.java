package tju.st.lab1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by gmy on 16/3/18.
 */
@RunWith(Parameterized.class)
public class TriangleTest {
    Triangle triangle;
    private int input1;
    private int input2;
    private int input3;
    private String expected;

    public TriangleTest(int input1, int input2, int input3, String expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3, "NotTriangle"},
                {3, 3, 3, "Equilateral"},
                {2, 7, 7, "Isosceles"},
                {3, 9, 7, "Scalene"}
        });
    }

    @Before
    public void setUp() throws Exception {
        triangle = new Triangle();
    }

    @Test
    public void testGetTriangleType() throws Exception {
        assertEquals(this.expected, triangle.getTriangleType(this.input1, this.input2, this.input3));
    }

    /**
     * 测试是否会抛出指定异常
     */
    @Test(expected = ArithmeticException.class)
    public void catchException() {
        throw new ArithmeticException();
    }

    /**
     * 超过300毫秒则无法通过测试
     */
    @Test(timeout = 600)
    public void testTimeout() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}