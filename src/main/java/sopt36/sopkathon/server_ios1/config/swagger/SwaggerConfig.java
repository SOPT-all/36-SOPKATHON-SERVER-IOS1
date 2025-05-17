package sopt36.sopkathon.server_ios1.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Sopkathon iOS1 API",
                version = "v1.0.0",
                description = "Sopkathon iOS1 팀의 REST API 명세서입니다."
        )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Sopkathon iOS1 API")
                        .version("v1.0.0")
                        .description("Sopkathon iOS1 팀의 REST API 명세서입니다.")
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Sopkathon iOS1 Backend Team")
                                .email("contact@sopkathon.io")
                                .url("https://github.com/sopt-sopkathon")
                        )
                );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("sopkathon-ios1-public")
                .pathsToMatch("/**")
                .build();
    }
}
