package com.sqisoft.peis_admin.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.sqisoft.peis_admin")
public class DatabaseConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {

        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        sqlSessionTemplate.getConfiguration().setCacheEnabled(false); // cache 설정 : default true
        sqlSessionTemplate.getConfiguration().setUseGeneratedKeys(false); // 자동 생성된 키를 반환 여부
        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true); // underscore를 camelCase로 매칭 : 예) user_id -> userId

        return sqlSessionTemplate;
    }
}
