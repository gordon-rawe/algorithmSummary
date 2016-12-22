package exponent;

/**
 * Created by gordon on 16/12/22.
 */
public class Exponent {
    public static double exponent(double base, int exponent) {
        if (base == 0d && exponent == 0) return -1d;
        int absExponent = Math.abs(exponent);
        double result = exponentCore(base, absExponent);
        if (exponent < 0) result = 1 / result;
        return result;
    }

    public static double exponentCore(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = exponentCore(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;
        return result;
    }

    public static void main(String[] args) {

    }
}
