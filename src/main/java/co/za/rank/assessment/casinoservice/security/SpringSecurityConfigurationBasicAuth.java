package co.za.rank.assessment.casinoservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : Mpholo Leboea
 * @Created : 2022/03/10
 **/

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

    //all these requires authentication
    private static final String[] PUBLIC_MATCHERS = {
          "/v1/transaction/top10/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.httpBasic();
        http.authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS)
                .authenticated()
                .anyRequest()
                .permitAll();
        http.csrf().disable().cors().disable();

        //allow connection to h2-console
        http.headers()
                .frameOptions()
                .sameOrigin();
    }

}
