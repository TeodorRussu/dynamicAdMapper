package advertising.mapper.dynamic.engine;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "special.fields")
public class SpecialFieldsMapper {

    private Map<String, String> mapped;

}
