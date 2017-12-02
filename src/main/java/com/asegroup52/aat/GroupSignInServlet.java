/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//[START all]
package com.asegroup52.aat;

import com.asegroup52.aat.model.Group;
import com.asegroup52.aat.model.Student;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

/**
 * Form Handling Servlet
 *
 */
public class GroupSignInServlet extends HttpServlet {

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student;
        Group group;

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();  // Find out who the user is.

        String studentId = req.getParameter("student");
        String groupName = req.getParameter("group");

        student = OrganizingService.getStudentFromUser(user);


        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.

        //ObjectifyService.ofy().delete().entity(student).now();
        student = new Student(student.id,student.email,student.nickname,groupName);
        ObjectifyService.ofy().save().entity(student).now();
        System.out.println("Student group: "+student.group);

        resp.sendRedirect("/index.jsp");
    }
}