package com.asegroup52.aat;

import com.asegroup52.aat.serverResource.AttendanceServerResource;
import com.asegroup52.aat.serverResource.GroupServerResource;
import com.asegroup52.aat.serverResource.StudentServerResource;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import java.io.FileInputStream;
import java.io.IOException;

public class RestApplication extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/groups", GroupServerResource.class);
        router.attach("/student/{studentId}", StudentServerResource.class);
        router.attach("/attendance", AttendanceServerResource.class);

        return router;
    }
}
