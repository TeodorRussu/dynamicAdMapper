package advertising.mapper.dynamic.engine.mapper;

import advertising.mapper.dynamic.engine.data.AdDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public interface InputMapper {
    List<String> readHeadersFromFile(File file);
    List<AdDTO> readAdsInputFromFile(File file);
}
