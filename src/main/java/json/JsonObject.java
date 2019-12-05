package json;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> p;

    public JsonObject(JsonPair... jsonPairs) {
        p = new ArrayList<>();
        for (JsonPair pair : jsonPairs){
            p.add(pair);
        }
    }

    public void add(JsonPair jsonPair) {
        p.add(jsonPair);
    }

    @Override
    public String toJson() {
        StringBuilder res = new StringBuilder("{");
        JsonPair pair;
        for (int i = 0; i < p.size(); i++){
            pair = p.get(i);

            res.append("'").append(pair.key).append("': '").append(pair.value);

            if (i != p.size() - 1) {
                res.append(", ");
            }
        }
        return res + "}";
    }




    public Json find(String name) {
        for (JsonPair pair : p) {
            if (pair.key == name) {
                return pair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject res = new JsonObject();
        for (String n : names) {
            Json found = find(n);
            if (found != null) {
                res.add(new JsonPair(n, found));
            }
        }
        return res;
    }
}
