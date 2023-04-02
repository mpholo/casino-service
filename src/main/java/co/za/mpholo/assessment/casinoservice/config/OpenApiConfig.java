package co.za.mpholo.assessment.casinoservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by  : Mpholo Leboea on 2023/04/02
 **/

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI casinoServiceApi() {
        return new OpenAPI()
                .info(new Info().title("Casino Service API")
                        .description("Casino Service API Assignment for BMW")
                        .version("v1.0.0"));

    }
}
