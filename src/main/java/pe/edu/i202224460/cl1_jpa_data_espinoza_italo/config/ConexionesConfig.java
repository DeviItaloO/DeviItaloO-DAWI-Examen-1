package pe.edu.i202224460.cl1_jpa_data_espinoza_italo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String dbWordUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWordUser;
    @Value("${DB_WORLD_PASS}")
    private String dbWordPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWordDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        // mi conexion
        hikariConfig.setJdbcUrl(dbWordUrl);
        hikariConfig.setUsername(dbWordUser);
        hikariConfig.setPassword(dbWordPass);
        hikariConfig.setDriverClassName(dbWordDriver);
        // personalizo
        hikariConfig.setMaximumPoolSize(30);
        hikariConfig.setMinimumIdle(4);
        hikariConfig.setIdleTimeout(240000);
        hikariConfig.setConnectionTimeout(45000);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public PlatformTransactionManager transactionManager(HikariDataSource hikariDataSource) {
        return new DataSourceTransactionManager(hikariDataSource);
    }
}
