package com.asegroup52.aat.servlets;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest();
        createRequest.setEmail(req.getParameter("email"));
        createRequest.setPassword(req.getParameter("password"));

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUserAsync(createRequest).get();
            String token = FirebaseAuth.getInstance().createCustomTokenAsync(userRecord.getUid()).get();

            resp.addCookie(new Cookie("token", token));
            resp.sendRedirect("/index.jsp");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            resp.sendRedirect("/index.jsp");
        }

//        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdTokenAsync("as").get();

    }
}
