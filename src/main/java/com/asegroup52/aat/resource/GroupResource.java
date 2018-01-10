package com.asegroup52.aat.resource;

import com.asegroup52.aat.model.Group;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface GroupResource {

    @Get
    Representation retrieve();

    @Put
    void store(Group group);

    @Delete
    void remove();
}
