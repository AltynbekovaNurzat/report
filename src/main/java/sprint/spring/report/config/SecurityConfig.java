package sprint.spring.report.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/sprint/exercise").permitAll()
                .antMatchers("/sprint/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/sprint/user/**").hasRole("ADMIN")
                .antMatchers("/sprint/report").hasAnyRole("USER","ADMIN")
                .antMatchers("/sprint/report/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and().logout().and().formLogin();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(encoder().encode("1234")).roles("ADMIN")
                .and().withUser("alina").password(encoder().encode("123")).roles("USER")
                .and().withUser("user").password(encoder().encode("123")).roles("USER");
    }
}