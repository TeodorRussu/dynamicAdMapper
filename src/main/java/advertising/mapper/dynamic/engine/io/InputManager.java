package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.AdDTO;
import advertising.mapper.dynamic.engine.data.InputData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InputManager {

    InputData readInput();
    List<String> readHeaders();
    List<AdDTO> readAdsInput();



}
