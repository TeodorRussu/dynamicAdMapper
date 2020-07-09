package advertising.mapper.dynamic.engine.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdDTO {

    private Map<String, String> field = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> any() {
        return field;
    }

    @JsonAnySetter
    public void set(String name, String value) {
        field.put(name, value);
    }

}
