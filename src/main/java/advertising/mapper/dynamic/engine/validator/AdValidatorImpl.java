package advertising.mapper.dynamic.engine.validator;

import advertising.mapper.dynamic.engine.data.Ad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdValidatorImpl implements AdValidator {

    @Override
    public boolean validate(Ad ad, List<String> headers) {
        for (String header : headers) {
            if (ad.getFields().get(header) == null){
                return false;
            }
        }
        return true;
    }
}
