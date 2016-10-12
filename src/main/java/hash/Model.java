package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gordon on 16/10/10.
 */
public class Model {
    public final int one;
    public final int two;
    public final int three;

    public Model(int one, int two, int three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Model)) return false;
        Model model = (Model) obj;
        return (model.one == one && model.two == two && model.three == three);
    }

    public static void main(String[] args) {
        Map<Model, String> map = new HashMap<>();
        Model key = new Model(1, 1, 1);
        map.put(new Model(1, 1, 1), "gordon");
        System.out.println(key.hashCode());
        key = new Model(1, 1, 1);
        System.out.println(key.hashCode());
        System.out.println(map.get(new Model(1, 1, 1)));
    }

    @Override
    public int hashCode() {
        int retValue = 17;
        retValue = retValue*31+one;
        retValue = retValue*31+two;
        retValue = retValue*31+three;
        return retValue;
    }
}
