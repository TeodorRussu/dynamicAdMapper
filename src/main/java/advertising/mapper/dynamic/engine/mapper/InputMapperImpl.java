package advertising.mapper.dynamic.engine.mapper;

import advertising.mapper.dynamic.engine.data.AdDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class InputMapperImpl implements InputMapper {

    @Override
    public List<String> readHeadersFromFile(File file) {
        return null;
    }

    @Override
    public List<AdDTO> readAdsInputFromFile(File file) {
        return null;
    }
}
