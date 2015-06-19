package demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * For detailed information please refer to "springfox" documentation
 * http://springfox.github.io/springfox/docs/snapshot/
 *
 * @author magiccrafter
 */
@Configuration
@EnableSwagger2
@PropertySource(value = "classpath:application.properties")
public class SwaggerConfig {

    @Value("${api.title}")
    private String apiTitle;

    @Value("${api.description}")
    private String apiDescription;

    @Value("${api.tosUrl}")
    private String apiTosUrl;

    @Value("${api.contact}")
    private String apiContact;

    @Value("${api.license}")
    private String apiLicense;

    @Value("${api.licenseUrl}")
    private String apiLicenseUrl;


    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiTitle)
                .description(apiDescription)
                .termsOfServiceUrl(apiTosUrl)
                .contact(apiContact)
                .license(apiLicense)
                .licenseUrl(apiLicenseUrl).build();
    }


//    /** Select any api that matches one of these paths */
//    private Predicate<String> apiPaths() {
//        return or(
//                regex("/rest.*"),
//                regex("/mvc.*")
//        );
//    }
}