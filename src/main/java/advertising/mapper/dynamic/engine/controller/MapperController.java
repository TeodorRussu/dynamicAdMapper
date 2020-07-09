package advertising.mapper.dynamic.engine.controller;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface MapperController {

    void action() throws IOException, CsvValidationException;

}
