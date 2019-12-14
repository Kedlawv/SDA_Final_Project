package com.sda.switter.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
public class SwitterAppConfig {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Value("${spring.datasource.driverClassName}")
    private String h2Driver;
    @Value("${spring.datasource.url}")
    private String h2Url;
    @Value("$spring.datasource.username")
    private String h2UserName;
    @Value("spring.datasource.password")
    private String h2Password;


    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try {
            securityDataSource.setDriverClass(h2Driver);
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        logger.info(">>> jdbc.url=" + h2Url);
        logger.info(">>> jdbc.user=" + h2UserName);

        securityDataSource.setJdbcUrl(h2Url);
        securityDataSource.setUser(h2UserName);
        securityDataSource.setPassword(h2Password);

//        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
//        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
//        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
//        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

//    private int getIntProperty(String propName) {
//        String propVal = env.getProperty(propName);
//
//        int intPropVal = Integer.parseInt(propVal);
//
//        return intPropVal;
//    }
}
