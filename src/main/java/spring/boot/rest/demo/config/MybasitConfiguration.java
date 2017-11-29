package spring.boot.rest.demo.config;
/**
 * {@link EnableAutoConfiguration Auto-Configuration} for Mybatis. Contributes a
 * {@link SqlSessionFactory} and a {@link SqlSessionTemplate}.
 *
 * If {@link org.mybatis.spring.annotation.MapperScan} is used, or a configuration file is
 * specified as a property, those will be considered, otherwise this auto-configuration
 * will attempt to register mappers based on the interface definitions in or under the
 * root auto-configuration package.
 *
 * @author Eddú Meléndez
 * @author Josh Long
 */

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageHelper;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * {type your description }
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
@Configuration
@EnableConfigurationProperties(MybatisProperties.class)
@CommonsLog
@ConditionalOnClass({ SqlSessionFactory.class, SqlSessionFactoryBean.class })
//@ConditionalOnBean(DataSource.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@MapperScan("spring.boot.rest.demo.mapper")
public class MybasitConfiguration {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private MybatisProperties properties;

    @Autowired(required = false)
    private Interceptor[] interceptors;

    @Autowired
    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    @PostConstruct
    public void checkConfigFileExists() {
        if (this.properties.isCheckConfigLocation()) {
            Resource resource = this.resourceLoader
                    .getResource(this.properties.getConfig());
            Assert.state(resource.exists(),
                    "Cannot find config location: " + resource
                            + " (please add config file or check your Mybatis "
                            + "configuration)");
        }
    }
//    @Bean(name = "sqlSessionFactory")
//    @ConditionalOnMissingBean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        factory.setDataSource(dataSource);
//        if (StringUtils.hasText(this.properties.getConfig())) {
//            factory.setConfigLocation(
//                    this.resourceLoader.getResource(this.properties.getConfig()));
//        } else {
//            if (this.interceptors != null && this.interceptors.length > 0) {
//                factory.setPlugins(this.interceptors);
//            }
//            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//            factory.setMapperLocations(this.properties.getMapperLocations());
//        }
//        return factory.getObject();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory,
//                this.properties.getExecutorType());
//    }
//
//    /**
//     * 分页插件
//     *
//     * @param dataSource
//     * @return
//     * @author SHANHY
//     * @create  2016年2月18日
//     */
//    @Bean
//    public PageHelper pageHelper(DataSource dataSource) {
//        log.info("注册MyBatis分页插件PageHelper");
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);

       // if (mybatisProperties.getMapperLocations().length > 0) {
            mybatisSqlSessionFactoryBean.setMapperLocations(properties.getMapperLocations());
        //}
        mybatisSqlSessionFactoryBean.setTypeAliasesPackage(properties.getTypeAliasesPackage());

        GlobalConfiguration globalConfiguration = new GlobalConfiguration();
        globalConfiguration.setDbColumnUnderline(true);
        globalConfiguration.setIdType(2);
        globalConfiguration.setDbType("mysql");
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfiguration);
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        Interceptor[] intercepto = new Interceptor[1];
        intercepto[0] = paginationInterceptor;
        mybatisSqlSessionFactoryBean.setPlugins(intercepto);

       return mybatisSqlSessionFactoryBean.getObject();
    }


    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
//
//    /**
//     * 分页插件
//     *
//     * @param dataSource
//     * @return
//     * @author SHANHY
//     * @create  2016年2月18日
//     */
//    @Bean
//    public PageHelper pageHelper(DataSource dataSource) {
//        log.info("注册MyBatis分页插件PageHelper");
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }
}
