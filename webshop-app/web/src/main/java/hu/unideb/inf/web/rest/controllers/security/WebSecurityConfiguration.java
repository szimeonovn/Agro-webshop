package hu.unideb.inf.web.rest.controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class allows the settings of the Spring Security.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PAGE_URL = "http://localhost:8080/agrowebshop/#/login";
    private static final String LOGIN_DEFAULT_SUCCESS_URL = "http://localhost:8080/agrowebshop";
    private static final String LOGIN_FAILURE_URL = "http://localhost:8080/agrowebshop/#/login";


    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .loginPage(LOGIN_PAGE_URL).loginProcessingUrl("/processLogin")
                .usernameParameter("email").passwordParameter("password")
                .defaultSuccessUrl(LOGIN_DEFAULT_SUCCESS_URL, true).failureUrl(LOGIN_FAILURE_URL)
                .and()
                .logout().logoutUrl("/appLogout").logoutSuccessUrl(LOGIN_PAGE_URL)
                .invalidateHttpSession(true);
    }

    /**
     * This method registers the defined user detail service and tells
     * which password encoder implemenation is used in the application when the password encoding happens.
     *
     * @param auth the auth
     * @throws Exception an exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}