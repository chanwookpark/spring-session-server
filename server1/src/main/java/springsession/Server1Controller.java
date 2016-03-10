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

        handler.addSessionValue("s1");

        return "ok (sid: " + handler.getSessionCookie() + ")";
    }
}
