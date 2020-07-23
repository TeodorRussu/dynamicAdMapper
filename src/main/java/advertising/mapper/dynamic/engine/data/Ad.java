package advertising.mapper.dynamic.engine.data;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Ad {
    private Map<String, String> fields = new HashMap<>();

    public void addField(String key, String value){
        fields.put(key, value);
    }

    public void replaceKeyName(String oldKey, String newKey){
        String value = fields.get(oldKey);
        fields.put(oldKey, null);
        fields.put(newKey, value);
    }

}
