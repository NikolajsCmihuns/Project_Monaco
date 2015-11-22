package AlexPackage.Spring;

/**
 * Created by Aborigens on 21-Nov-15.
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // is saying that this is configuraion file
//@ComponentScan(basePackages = {"lv.javaguru.java2"}) // which packages search for components; if multiple use coma to define all
@ComponentScan(basePackages = {"AlexPackage"})
public class SpringConfig {



}
