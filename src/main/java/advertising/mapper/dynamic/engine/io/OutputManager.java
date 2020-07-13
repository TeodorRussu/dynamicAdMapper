package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.Ad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OutputManager {

    void exportOutput(List<Ad> ads);
}
