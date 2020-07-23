package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.AdDTO;
import advertising.mapper.dynamic.engine.data.InputData;
import advertising.mapper.dynamic.engine.mapper.DynamicAdMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class InputManagerImpl implements InputManager {

    @Autowired
    private DynamicAdMapper dynamicAdMapper;

    @Autowired
    private S3FileReaderImpl s3FileReader;

    @Value("${aws.s3region:us-east-1}")
    @Setter
    private String region;

    @Setter
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Setter
    @Value("${input.fileName.headers}")
    private String headerFileName;

    @Setter
    @Value("${input.fileName.data}")
    private String inputFileName;

    @Override
    public InputData readInput() throws IOException {
        List<String> headers = readHeadersFromFile();
        List<AdDTO> adsData = readAdsInputFromFile();
        return InputData.builder()
                .headers(headers)
                .adsData(adsData)
                .build();
    }

    @Override
    public List<String> readHeadersFromFile() {
        File file = s3FileReader.getInputFile(bucketName, headerFileName);
        String[] headers = null;

        try (FileReader reader = new FileReader(file);
             CSVReader csvReader = new CSVReader(reader)) {
            headers = csvReader.readNext()[0].split(";");
        } catch (IOException | CsvValidationException e) {
            log.error(e.getMessage());
        }
        return Arrays.asList(headers);
    }

    @Override
    public List<AdDTO> readAdsInputFromFile() throws IOException {
        File file = s3FileReader.getInputFile(bucketName, inputFileName);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true);


        AdDTO[] inputData = null;
        if (file.isFile()) {
            try {
              inputData = mapper.readValue(file, AdDTO[].class);

            } catch (JsonParseException | MismatchedInputException fileParsingException) {
                log.error("File: {}, parsing error. Exception: {}. The file is invalid.", file.getName(),
                          fileParsingException.getMessage());
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return Arrays.asList(inputData);
    }

}
