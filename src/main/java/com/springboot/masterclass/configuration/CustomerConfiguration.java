package com.springboot.masterclass.configuration;

import com.springboot.masterclass.customer.dao_layer.CustomerFakeRepository;
import com.springboot.masterclass.customer.dao_layer.CustomerRepo;
import com.springboot.masterclass.infoapp.InfoApp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.FeignClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CustomerConfiguration {

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
            log.info("Command Line Runner Hooray ");
//            log.info("" +infoApp);
//            log.info(companyName);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        log.info("useFakeCustomerRepo " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
