package advertising.mapper.dynamic.engine.io;

import advertising.mapper.dynamic.engine.data.Ad;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class OutputManagerImpl implements OutputManager {

    @Value("${aws.s3region:us-east-1}")
    @Setter
    private String region;

    @Setter
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Setter
    @Value("${output.fileName}")
    private String outputFileName;


    @Override
    public void exportOutput(List<Ad> ads) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File(outputFileName);
        file.deleteOnExit();

        mapper.writerWithDefaultPrettyPrinter().writeValue(file, ads);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(region).build();

        s3Client.putObject(bucketName, outputFileName, file);
    }
}
