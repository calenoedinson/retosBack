package co.usa.ciclo3.ciclo3.oauth2;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ecaleno
 */
@RestController
public class ControladorSeguridad extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/","/no-restriccion"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        
        /*
        http.authorizeRequests(a -> a
                .antMatchers("/", "/url/**", "/error", "/webjars/**", "/Reservation/**",
                        "/client/**", "/Score/**", "/Message/**",
                        "/Cabin/**", "/Category/**").permitAll()
                .anyRequest().authenticated()
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login();
         */
        
        http.cors().and().csrf().disable();

    }

}
