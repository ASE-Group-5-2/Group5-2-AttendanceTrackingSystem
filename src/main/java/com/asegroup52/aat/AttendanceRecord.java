package com.asegroup52.aat;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

import java.util.Date;
import java.util.UUID;

@Entity
public class AttendanceRecord {
    @Id public String id;
    @Parent public Key<Student> studentKey;
    public Key<Group> groupKey;
    public Key<Week> week;
    public Boolean presented;
    public Date date;

    /**
     * Simple constructor just sets the date
     **/
    public AttendanceRecord()  {
        date = new Date();
        id = UUID.randomUUID().toString();
    }

    /**
     * A constructor with any key
     **/
    public AttendanceRecord(String studentKey, String groupKey, String weekKey, Boolean presented) {
        this();
        this.studentKey = Key.create(Student.class, studentKey);
        this.groupKey = Key.create(Group.class, groupKey);
        this.week = Key.create(Week.class, weekKey);
        this.presented = presented;
    }
}
