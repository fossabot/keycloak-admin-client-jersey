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
import org.keycloak.representations.idm.SynchronizationResultRepresentation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * The type User storage provider resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by bill@burkecentral.com.
 *
 * @author daniel-schel
 */
public class UserStorageProviderResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected UserStorageProviderResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new User storage provider resource.
     *
     * @param target the target
     * @param path   the path
     */
    public UserStorageProviderResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    /**
     * If the provider supports synchronization, this will invoke it.
     *
     * Action can be "triggerFullSync" or "triggerChangedUsersSync"
     *
     *
     * @param componentId
     * @param action
     * @return
     */
    @POST
    @Path("{componentId}/sync")
    @Produces(MediaType.APPLICATION_JSON)
    public SynchronizationResultRepresentation syncUsers(@PathParam("componentId") String componentId, @QueryParam("action") String action) {
        throw new UnsupportedOperationException();
    }

    /**
     * Remove imported users
     *
     *
     * @param componentId
     * @return
     */
    @POST
    @Path("{componentId}/remove-imported-users")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeImportedUsers(@PathParam("componentId") String componentId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unlink imported users from a storage provider
     *
     * @param componentId
     * @return
     */
    @POST
    @Path("{componentId}/unlink-users")
    @Produces(MediaType.APPLICATION_JSON)
    public void unlink(@PathParam("componentId") String componentId) {
        throw new UnsupportedOperationException();
    }

    /**
     * REST invocation for initiating sync for an ldap mapper.  This method may be moved in the future.  Right now
     * don't have a good place for it.
     *
     * direction is "fedToKeycloak" or "keycloakToFed"
     *
     *
     * @param componentId
     * @param mapperId
     * @param direction
     * @return
     */
    @POST
    @Path("{componentId}/mappers/{mapperId}/sync")
    @Produces(MediaType.APPLICATION_JSON)
    public SynchronizationResultRepresentation syncMapperData(@PathParam("componentId") String componentId, @PathParam("mapperId") String mapperId, @QueryParam("direction") String direction) {
        throw new UnsupportedOperationException();
    }


}
