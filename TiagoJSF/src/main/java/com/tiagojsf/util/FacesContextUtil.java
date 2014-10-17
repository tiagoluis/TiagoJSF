package com.tiagojsf.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;
/** 
 * Util para setar e resgatar a Session do hibernate
 * @author Tiago
 */
public class FacesContextUtil {

    private static final String HIBER_SESSION = "hibernate_session";

    public static void setRequestSession(Session session) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBER_SESSION, session);
    }
    
    public static Session getRequestSession() {
        return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBER_SESSION);
    }

}
