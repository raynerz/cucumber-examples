package ch.alika.cukes.shopping.steps;

import ch.alika.cukes.shopping.support.ShoppingHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Slf4j
@Configuration
public class ShoppingStepsSpringConfiguration {

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public ShoppingHelper shopperHelper() {
        log.debug("Instantiating ShoppingHelper");
        return new ShoppingHelper();
    }
}
