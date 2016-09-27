/**
 * Created by gordon on 16/9/26.
 */
public class StringCompare {
    public static void main(String[] args) {
        String one = "something";
        String two = "something".intern();
        System.out.println(one==two);
    }
}
