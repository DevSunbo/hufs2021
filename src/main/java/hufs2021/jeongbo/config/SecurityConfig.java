package hufs2021.jeongbo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .disable()
                .csrf()
                    .disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                    .anyRequest().permitAll()
                .and()
                .formLogin().disable();
//                    .loginPage("/login")
//                    .loginProcessingUrl("/login/process")
//                    .usernameParameter("student_id")
//                    .passwordParameter("password")
//                    .defaultSuccessUrl("/success");
//                .headers().frameOptions().disable();
    }
}
