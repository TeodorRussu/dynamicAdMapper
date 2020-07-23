package advertising.mapper.dynamic.engine.validator;

import advertising.mapper.dynamic.engine.data.Ad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdValidator {
    boolean validate(Ad ad, List<String> headers);
}
