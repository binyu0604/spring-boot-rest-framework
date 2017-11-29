package spring.boot.rest.common.config;

//import org.springframework.boot.context.embedded.ServletRegistrationBean;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;


//@Configuration
public class DruidConfiguration {

    //@Bean
//    public ServletRegistrationBean druidServlet() {
//
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        //登录查看信息的账号密码.
//
//        servletRegistrationBean.addInitParameter("loginUsername","admin");
//
//        servletRegistrationBean.addInitParameter("loginPassword","123456");
//        return servletRegistrationBean;
//    }

    //@Bean(destroyMethod = "close")
//    public DataSource druidDataSource(@Value("${master.jdbc.driverClassName}") String driver,
//                                      @Value("${master.jdbc.url}") String url,
//                                      @Value("${master.jdbc.username}") String username,
//                                      @Value("${master.jdbc.password}") String password) {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(driver);
//        druidDataSource.setUrl(url);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
//        try {
//            druidDataSource.setFilters("stat, wall");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return druidDataSource;
//    }

   //@Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
