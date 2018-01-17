package com.asegroup52.aat.servlets;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;

public class ContextListenerServlet implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("ase-project-5-2-firebase-adminsdk-rntdq-ef807aefbb.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ase-project-5-2.firebaseio.com")
                    .build();

            FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
