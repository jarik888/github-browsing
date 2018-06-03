package artjuh.jaroslav.githubbrowsing.controller;

import artjuh.jaroslav.githubbrowsing.model.UserData;
import artjuh.jaroslav.githubbrowsing.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin(origins = {"${allowedOrigin}"})
@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "login", method = GET)
    public UserData getData(@RequestParam String code) {
        return authService.getUserData(code);
    }
}
