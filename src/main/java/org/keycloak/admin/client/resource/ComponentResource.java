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
import org.keycloak.representations.idm.ComponentRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * The type Component resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by bill@burkecentral.com.
 *
 * @author daniel-schel
 */
public class ComponentResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected ComponentResource(WebResource target) {
        super(target);
    }

    public ComponentResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    public ComponentRepresentation toRepresentation() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(ComponentRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
