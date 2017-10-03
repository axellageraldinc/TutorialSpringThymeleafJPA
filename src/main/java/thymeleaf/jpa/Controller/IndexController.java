package thymeleaf.jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import thymeleaf.jpa.Model.User;
import thymeleaf.jpa.Repository.UserRepository;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("message", "Hai sayang");
        List<User> users = (List<User>) userRepository.findAll();
        mav.addObject("users", users);
        return mav;
    }

    @GetMapping(value = "/name", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView name(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        List<User> usersByName = userRepository.findByNama("Kempl");
        for (User user: usersByName
             ) {
            System.out.println("ID : " + user.getId());
            System.out.println("NAMA : " + user.getNama());
            System.out.println("ALAMAT : " + user.getAlamat());
        }
        return mav;
    }
}
