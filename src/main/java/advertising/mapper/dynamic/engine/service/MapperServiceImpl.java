package advertising.mapper.dynamic.engine.service;

import advertising.mapper.dynamic.engine.data.Ad;
import advertising.mapper.dynamic.engine.data.AdDTO;
import advertising.mapper.dynamic.engine.data.InputData;
import advertising.mapper.dynamic.engine.mapper.DynamicAdMapper;
import advertising.mapper.dynamic.engine.validator.AdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperServiceImpl implements MapperService {

    @Autowired
    private DynamicAdMapper dynamicAdMapper;
    @Autowired
    private AdValidator adValidator;


    @Override
    public List<Ad> processInput(InputData input) {

        List<Ad> outputAds = new ArrayList<>();
        List<AdDTO> invalidEntries = new ArrayList<>();

        for (AdDTO adDTO : input.getAdsData()) {
            Ad ad = dynamicAdMapper.mapAdInput(adDTO, input.getHeaders());

            if(adValidator.validate(ad, input.getHeaders())){
                outputAds.add(ad);
            }else {
                invalidEntries.add(adDTO);
            }
        }

        return outputAds;
    }
}
