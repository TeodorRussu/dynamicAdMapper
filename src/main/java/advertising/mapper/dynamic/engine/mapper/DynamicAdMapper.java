package advertising.mapper.dynamic.engine.mapper;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.AdDTO;
import org.springframework.stereotype.Component;

@Component
public interface DynamicAdMapper {

    Ad mapAdInput(AdDTO adDTO);

}
