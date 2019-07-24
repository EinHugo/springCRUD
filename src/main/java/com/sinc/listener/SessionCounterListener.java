package com.sinc.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounterListener implements HttpSessionListener {

	static private int activeSessions;
	 
    public static int getActiveSessions() {
         return activeSessions;
     }
 
    @Override
     public void sessionCreated(HttpSessionEvent arg0) {
         activeSessions++;
         
         System.out.println("Created!! activeSessions : " + activeSessions);
     }
 
    @Override
     public void sessionDestroyed(HttpSessionEvent arg0) {
         activeSessions--;
         System.out.println("Destoryed!! activeSessions : " + activeSessions);
     }

}
