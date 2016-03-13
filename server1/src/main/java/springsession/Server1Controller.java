package springsession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springsession.common.SessionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chanwook
 */
@RestController
public class Server1Controller {

    @RequestMapping("/session")
    public String index(HttpServletRequest req) {

        final SessionHandler handler = new SessionHandler(req);

        handler.addSessionValue("p");
        String value = (String) handler.getSessionValue("p");

        return "ok (sid: " + handler.getSessionCookie() + ", param is " + value + ")";
    }
}
