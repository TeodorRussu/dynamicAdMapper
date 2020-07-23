package advertising.mapper.dynamic.engine.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InputData {
    private List<String> headers;
    private List<AdDTO> adsData;
}
