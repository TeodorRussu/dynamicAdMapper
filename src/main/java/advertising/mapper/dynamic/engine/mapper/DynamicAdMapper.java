package advertising.mapper.dynamic.engine.mapper;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.AdDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DynamicAdMapper {

    Ad mapAdInput(AdDTO adDTO, List<String> headers);

}
