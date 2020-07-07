package advertising.mapper.dynamic.engine.service;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.InputData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MapperService {

    List<Ad> processInput(InputData input);

}
