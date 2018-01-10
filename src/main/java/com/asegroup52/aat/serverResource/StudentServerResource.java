package com.asegroup52.aat.serverResource;

import com.asegroup52.aat.model.Student;
import com.asegroup52.aat.resource.StudentResource;
import com.asegroup52.aat.tools.NetworkUtils;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;

public class StudentServerResource extends ServerResource implements StudentResource {

    @Override
    public Representation retrieve() {
        Key<Student> theGreeting = Key.create(Student.class, getAttribute("studentId"));
        Student greeting = ObjectifyService.ofy()
                .load()
                .key(theGreeting)
                .now();
        return new JsonRepresentation(NetworkUtils.getGson().toJson(greeting));
    }

    @Override
    public void store(Student student) {
        ObjectifyService.ofy().save().entity(student);
    }

    @Override
    public void remove() {

    }
}
