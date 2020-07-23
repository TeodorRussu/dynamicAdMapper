package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.AdDTO;
import advertising.mapper.dynamic.engine.data.InputData;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface InputManager {

    InputData readInput() throws IOException, CsvValidationException;
    List<String> readHeadersFromFile() throws IOException, CsvValidationException;
    List<AdDTO> readAdsInputFromFile() throws IOException;

}
