package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.Ad;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface OutputManager {

    void exportOutput(List<Ad> ads) throws IOException;
}
