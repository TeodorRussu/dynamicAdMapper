package advertising.mapper.dynamic.engine.mapper;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.AdDTO;
import org.springframework.stereotype.Component;

@Component
public class DynamicAdMapperImpl implements DynamicAdMapper {

    @Override
    public Ad mapAdInput(AdDTO adDTO) {
        return new Ad();
    }

}
