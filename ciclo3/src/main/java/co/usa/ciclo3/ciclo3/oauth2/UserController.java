package co.usa.ciclo3.ciclo3.oauth2;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ecaleno
 */
@RestController
public class UserController {   
    @GetMapping("/")
    public String helloword(){
        return "no es necesario estar conectado";
    }
    
    @GetMapping("/no-restriccion")
    public String noRestricted(){
        return "no es necesario estar conectado";
    }    
    
    @GetMapping("/restringido")
    public Map<String ,Object> user(@AuthenticationPrincipal OAuth2User principal){
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }    
}
