package com.asegroup52.aat.serverResource;

import com.asegroup52.aat.model.Group;
import com.asegroup52.aat.resource.GroupResource;
import com.asegroup52.aat.tools.NetworkUtils;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;

public class GroupServerResource extends ServerResource implements GroupResource {

    @Override
    public Representation retrieve() {
        return new JsonRepresentation(NetworkUtils.getGson().toJson(new Group()));
    }

    @Override
    public void store(Group group) {

    }

    @Override
    public void remove() {

    }
}
