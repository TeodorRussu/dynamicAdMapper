package advertising.mapper.dynamic.engine.io;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public interface S3FileReader {

    File getInputFile(String bucketName, String fileName);
}
