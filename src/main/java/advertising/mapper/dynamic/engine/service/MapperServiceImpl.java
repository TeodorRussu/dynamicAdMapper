package advertising.mapper.dynamic.engine.service;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.InputData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperServiceImpl implements MapperService{

    @Override
    public List<Ad> processInput(InputData input) {
        return List.of(new Ad());
    }
}
