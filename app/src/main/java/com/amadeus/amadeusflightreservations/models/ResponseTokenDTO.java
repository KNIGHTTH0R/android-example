package com.amadeus.amadeusflightreservations.models;

public class ResponseTokenDTO {

    private String username;

    private String scope;

    private String application_name;

    private String state;

    private String expires_in;

    private String token_type;

    private String client_id;

    private String type;

    private String access_token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getApplication_name() {
        return application_name;
    }

    public void setApplication_name(String application_name) {
        this.application_name = application_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "[username = " + username + ", scope = " + scope + ", application_name = " + application_name + ", state = " + state + ", expires_in = " + expires_in + ", token_type = " + token_type + ", client_id = " + client_id + ", type = " + type + ", access_token = " + access_token + "]";
    }

}
