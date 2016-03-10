package springsession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springsession.common.SessionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chanwook
 */
@RestController
public class Server2Controller {

    private final Logger logger = LoggerFactory.getLogger(Server2Controller.class);

    @RequestMapping("/session")
    public String index(HttpServletRequest req) {

        final SessionHandler handler = new SessionHandler(req);

        String value = handler.getSessionValue("s1");

        return "ok (sid: " + handler.getSessionCookie() + ", s1 value: " + value + ")";
    }
}
