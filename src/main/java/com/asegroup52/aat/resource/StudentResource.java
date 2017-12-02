package com.asegroup52.aat.resource;

import com.asegroup52.aat.model.Student;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface StudentResource {

    @Get
    Representation retrieve();

    @Put
    void store(Student student);

    @Delete
    void remove();
}
