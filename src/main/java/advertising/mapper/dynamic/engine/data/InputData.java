package advertising.mapper.dynamic.engine.data;

import lombok.Data;

import java.util.List;

@Data
public class InputData {
    private List<String> headers;
    private List<AdDTO> adsData;
}
