package advertising.mapper.dynamic.engine.mapper;

import advertising.mapper.dynamic.engine.SpecialFieldsMapper;
import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.AdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DynamicAdMapperImpl implements DynamicAdMapper {
    @Autowired
    SpecialFieldsMapper specialFieldsMapper;

    @Override
    public Ad mapAdInput(AdDTO adDTO, List<String> headers) {

        Ad ad = new Ad();

        for (String header : headers) {
            ad.addField(header, adDTO.getFieldValue(header));
        }

        mapSpecialFields(ad, adDTO);
        return ad;
    }

    private void mapSpecialFields(Ad ad, AdDTO adDTO) {
        Map<String, String> fieldsWithSpecialMapping = specialFieldsMapper.getMapped();
        fieldsWithSpecialMapping.forEach((key, value) -> ad.addField(value, adDTO.getFieldValue(key)));
    }

}
