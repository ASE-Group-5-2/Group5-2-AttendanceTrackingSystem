package com.asegroup52.aat;

import com.asegroup52.aat.model.Group;
import com.asegroup52.aat.model.Student;
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
        System.out.println("Loading default groups.");
        List<Group> groups = new ArrayList<>();
        groups.add(new Group("Group 1", "Mondays 09:00 - 11:00", "01.11.018", "Ana"));
        groups.add(new Group("Group 2", "Mondays 13:45 - 15:15", "01.11.018", "Sebastian"));
        groups.add(new Group("Group 3", "Mondays 15:15 - 16:45", "01.11.018", "Sebastian"));
        groups.add(new Group("Group 4", "Tuesdays 15:00 - 17:00", "01.11.018", "Ehsan"));
        groups.add(new Group("Group 5", "Wednesdays 10:00 - 12:00", "01.11.038", "Mohsen"));
        groups.add(new Group("Group 6", "Wednesdays 12:00 - 14:00", "01.11.018", "Saahil"));


        ObjectifyService.ofy().save().entities(groups);
        return groups;
    }
}
