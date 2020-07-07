package advertising.mapper.dynamic;

import advertising.mapper.dynamic.engine.SpecialFieldsMapper;
import advertising.mapper.dynamic.engine.controller.MapperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicAdvertisingMapperApplication implements CommandLineRunner {

	@Autowired
	private MapperController mapperController;
	@Autowired
	private SpecialFieldsMapper specialFieldsMapper;

    public static void main(String[] args) {
        SpringApplication.run(DynamicAdvertisingMapperApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

	}
}
