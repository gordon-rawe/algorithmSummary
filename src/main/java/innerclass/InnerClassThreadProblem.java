package innerclass;

/**
 * Created by gordon on 9/27/16.
 */
public class InnerClassThreadProblem {



    public void method() {
        final int[] x = {1};
        new X() {
            @Override
            public void xxx() {
                super.xxx();
                x[0] =2;
            }
        };
    }

    class X {
        public void xxx() {
        }
    }
}