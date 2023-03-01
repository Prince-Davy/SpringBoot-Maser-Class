package com.springboot.masterclass.configuration;

import com.springboot.masterclass.customer.dao_layer.CustomerFakeRepository;
import com.springboot.masterclass.customer.dao_layer.CustomerRepo;
import com.springboot.masterclass.infoapp.InfoApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.FeignClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    final static Logger logger = LoggerFactory.getLogger(CustomerConfiguration.class);

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

//    @Value("${info.company.name}")
//    private String companyName;

//    @Autowired
//    private Environment environment;


    public FeignClientFactory feignClientFactory() {
        return new FeignClientFactory();
    }

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            logger.info("Command Line Runner Hooray ");
            System.out.println(infoApp );
            //logger.info(companyName);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        logger.info("useFakeCustomerRepo " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
