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

package org.keycloak.admin.client;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import org.keycloak.admin.client.token.TokenManager;

import javax.ws.rs.core.HttpHeaders;

/**
 * The type Bearer auth filter.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class BearerAuthFilter extends ClientFilter {

    public static final String AUTH_HEADER_PREFIX = "Bearer ";
    private final String tokenString;
    private final TokenManager tokenManager;

    public BearerAuthFilter(String tokenString) {
        this.tokenString = tokenString;
        this.tokenManager = null;
    }

    public BearerAuthFilter(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        this.tokenString = null;
    }

    @Override
    public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
        if (!cr.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            String authHeader = (tokenManager != null ? tokenManager.getAccessTokenString() : tokenString);
            if (!authHeader.startsWith(AUTH_HEADER_PREFIX)) {
                authHeader = AUTH_HEADER_PREFIX + authHeader;
            }
            cr.getHeaders().add(HttpHeaders.AUTHORIZATION, authHeader);
        }

        return this.getNext().handle(cr);
    }

}
