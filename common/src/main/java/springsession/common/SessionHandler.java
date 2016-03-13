package springsession.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chanwook
 */
public class SessionHandler {

    private final Logger logger = LoggerFactory.getLogger(SessionHandler.class);

    private final HttpServletRequest request;

    public SessionHandler(HttpServletRequest request) {
        this.request = request;
    }

    public String getSessionCookie() {
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if ("SESSION".equals(c.getName())) {
                    logger.info("Session Cookie: " + c.getValue());
                    return c.getValue();
                }
            }
        }
        return "NO SESSION";
    }

    public void addSessionValue(String key) {
        final String param = request.getParameter(key);

        if (StringUtils.hasText(param)) {
            logger.info("[Session value] from '" + getSessionValue(key) + "' to ' " + param + "'");
            request.getSession().setAttribute(key, param);
        } else {
            logger.info("param is empty...");
        }

    }

    public void addSessionValue(String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public Object getSessionValue(String key) {
        return request.getSession().getAttribute(key);
    }

}
