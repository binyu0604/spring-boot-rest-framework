package spring.boot.rest.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.ExecutorType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

/**
 * Created by skywing on 2017/4/7.
 */

@Setter
@Getter
@ConfigurationProperties(prefix = MybatisProperties.MYBATIS_PREFIX)
public class MybatisProperties {
    public static final String MYBATIS_PREFIX = "mybatis";

    /**
     * Config file path.
     */
    private String config;

    /**
     * Location of mybatis mapper files.
     */
    private Resource[] mapperLocations;

    /**
     * Package to scan domain objects.
     */
    private String typeAliasesPackage;

    /**
     * Package to scan handlers.
     */
    private String typeHandlersPackage;

    /**
     * Check the config file exists.
     */
    private boolean checkConfigLocation = false;

    /**
     * Execution mode.
     */
    private ExecutorType executorType = ExecutorType.SIMPLE;
}
