package thymeleaf.jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import thymeleaf.jpa.Model.User;
import thymeleaf.jpa.Repository.UserRepository;

import javax.sql.DataSource;

@RestController
public class InsertController {

    @Autowired
    UserRepository userRepository;
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostMapping(value = "/insert-data", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView doInsert(@ModelAttribute("user")User user){
        ModelAndView mav = new ModelAndView();
        userRepository.save(user);
        mav.setViewName("index");
        return mav;
    }
}
