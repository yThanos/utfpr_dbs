package dev.fraporti.utfpr_dbs.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Configuration
@EnableJpaRepositories("dev.fraporti.utfpr_dbs.repository")
@EnableTransactionManagement
public class SpringDataConfig {
    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setJdbcUrl("jdbc:h2:mem:teste");
        ds.setDriverClassName("org.h2.Driver");

        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("dev.fraporti.utfpr_dbs.model");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        transactionManager.setJpaDialect(new HibernateJpaDialect());

        return transactionManager;
    }
}
