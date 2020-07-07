package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.AdDTO;
import advertising.mapper.dynamic.engine.data.InputData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InputManagerImpl implements InputManager {

    @Override
    public InputData readInput() {
        return null;
    }

    @Override
    public List<String> readHeaders() {
        return null;
    }

    @Override
    public List<AdDTO> readAdsInput() {
        return null;
    }
}
