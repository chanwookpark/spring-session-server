package springsession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springsession.common.SessionHandler;

import javax.servlet.http.HttpServletRequest;

import static springsession.User.SESSION_KEY;

/**
 * @author chanwook
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String view() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String process(HttpServletRequest request) {

        final SessionHandler handler = new SessionHandler(request);
        handler.addSessionValue(SESSION_KEY, createUserToLogin(request));

        return "redirect:/users";
    }

    @RequestMapping("/users")
    public String users(HttpServletRequest req) {

        final SessionHandler handler = new SessionHandler(req);

        final User user = (User) handler.getSessionValue(SESSION_KEY);

        return "user";
    }

    private User createUserToLogin(HttpServletRequest request) {
        final String userName = request.getParameter("userName");
        final String password = request.getParameter("password");

        return new User(userName, password);
    }
}
