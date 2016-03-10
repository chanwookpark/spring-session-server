package springsession;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author chanwook
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(SessionConfig.class);
    }
}
