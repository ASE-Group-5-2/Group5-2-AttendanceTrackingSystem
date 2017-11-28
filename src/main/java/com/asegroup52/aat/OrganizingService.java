package com.asegroup52.aat;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class OrganizingService {
    public static Student getStudentFromUser(User user){
        Key<Student> studentKey = Key.create(Student.class, user.getUserId());
        Student student = ObjectifyService.ofy().load().key(studentKey).now();
        //System.out.println("student "+student);

        if(student == null){ //String student_id, String student_email, String student_name, String nickname
            student = new Student(user.getUserId(), user.getEmail(), user.getNickname());
            ObjectifyService.ofy().save().entity(student).now();
        }
        return student;
    }
}
