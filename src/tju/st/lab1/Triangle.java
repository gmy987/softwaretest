package tju.st.lab1;

/**
 * Created by gmy on 16/3/18.
 */
public class Triangle {
    public String getTriangleType(int a, int b, int c) {
        int tmpc = Math.max(Math.max(a, b), c);
        if (tmpc == a) {
            a = c;
            c = tmpc;
        } else if (tmpc == b) {
            b = c;
            c = tmpc;
        }
        if (a + b <= c) {
            return "NotTriangle";
        } else if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b||a==c||b==c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}
