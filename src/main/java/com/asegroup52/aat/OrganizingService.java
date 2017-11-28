package com.asegroup52.aat;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import java.util.ArrayList;
import java.util.List;

public class OrganizingService {
    public static Student getStudentFromUser(User user){
        Key<Student> studentKey = Key.create(Student.class, user.getUserId());
        Student student = ObjectifyService.ofy().load().key(studentKey).now();
        //System.out.println("student "+student);

        if(student == null){ //String student_id, String student_email, String student_name, String nickname
            System.out.println("Create new student");
            student = new Student(user.getUserId(), user.getEmail(), user.getNickname());
            ObjectifyService.ofy().save().entity(student).now();
        }
        System.out.println("Load student: "+student+" id "+student.id);
        System.out.println("Student group: "+student.group);
        return student;
    }

    public static List<Group> loadDefaultGroups(){
        List<Group> groups = new ArrayList<>();
        System.out.println("Loading default groups.");

        for(int i = 1; i < 7; i++){
            for(int j = 1; j < 11; j++){
                groups.add(new Group("group"+i+"-"+j));
            }
        }

        ObjectifyService.ofy().save().entities(groups);
        return groups;
    }
}
