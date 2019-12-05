package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final boolean b;


    public JsonBoolean(Boolean bool) {
        this.b = bool;

    }

    @Override
    public String toJson() {
        if (b == true) {
            return "true";
        }
        return "false";
    }
}
