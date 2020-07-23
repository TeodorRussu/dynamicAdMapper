package advertising.mapper.dynamic.engine.controller;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.InputData;
import advertising.mapper.dynamic.engine.io.InputManager;
import advertising.mapper.dynamic.engine.io.OutputManager;
import advertising.mapper.dynamic.engine.service.MapperService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MapperControllerImpl implements MapperController {

    @Autowired
    private InputManager inputManager;
    @Autowired
    private OutputManager outputManager;
    @Autowired
    private MapperService mapperService;

    @Override
    public void action() throws IOException, CsvValidationException {
        InputData inputData = inputManager.readInput();
        List<Ad> processed = mapperService.processInput(inputData);
        outputManager.exportOutput(processed);
    }
}
