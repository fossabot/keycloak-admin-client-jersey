/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
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

package org.keycloak.admin.client.resource;

import com.sun.jersey.api.client.WebResource;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Resources resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by psilva@redhat.com.
 *
 * @author daniel-schel
 */
public class ResourcesResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected ResourcesResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Resources resource.
     *
     * @param target the target
     * @param path   the path
     */
    public ResourcesResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ResourceRepresentation resource) {
        throw new UnsupportedOperationException();
    }

    @Path("{id}")
    public ResourceResource resource(@PathParam("id") String id) {
        return new ResourceResource(getTarget(), path + "/" + id);
    }

    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResourceRepresentation> find(@QueryParam("name") String name,
                  @QueryParam("uri") String uri,
                  @QueryParam("owner") String owner,
                  @QueryParam("type") String type,
                  @QueryParam("scope") String scope,
                  @QueryParam("first") Integer firstResult,
                  @QueryParam("max") Integer maxResult) {
        throw new UnsupportedOperationException();
    }

    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResourceRepresentation> findByName(@QueryParam("name") String name) {
        throw new UnsupportedOperationException();
    }

    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResourceRepresentation> findByName(@QueryParam("name") String name, @QueryParam("owner") String owner) {
        throw new UnsupportedOperationException();
    }

    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResourceRepresentation> resources() {
        throw new UnsupportedOperationException();
    }
}
