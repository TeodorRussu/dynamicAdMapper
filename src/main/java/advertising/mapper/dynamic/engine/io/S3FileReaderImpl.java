package advertising.mapper.dynamic.engine.io;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
@Slf4j
public class S3FileReaderImpl implements S3FileReader{
    public File getInputFile(String bucketName, String fileName) {

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("eu-central-1").build();
        File file = new File(fileName);
        file.deleteOnExit();

        try (S3Object s3Object = s3Client.getObject(bucketName, fileName);
             InputStreamReader streamReader = new InputStreamReader(s3Object.getObjectContent());
             OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
             BufferedReader reader = new BufferedReader(streamReader)) {

            int read;
            while ((read = reader.read()) != -1) {
                if(read == 8211){
                    read = 45;
                }
                writer.write(read);
            }
            writer.flush();
            log.info("file {} downloladed from S3 bucket", fileName);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return file;
    }
}
