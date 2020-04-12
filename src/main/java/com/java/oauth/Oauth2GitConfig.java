package com.java.oauth;

public class Oauth2GitConfig {
    public static final String AUTHORIZE_URL="https://github.com/login/oauth/authorize";
    public static final String ACCESS_TOKEN_URL=" https://github.com/login/oauth/access_token";
    public static final String CALLBACK_URL="http://localhost:8081/oauth2-login-app/login";
    public static final String CLIENT_ID="6b3818cbf6403a59301f";
    public static final String CLIENT_SECRET="da4c23b8f92ef5fbad4ca0f64daac6da2034dace";
    public static final String REQUEST_CODE_URL=AUTHORIZE_URL+"?client_id="+CLIENT_ID+"&redirect_uri="+CALLBACK_URL+"&scope=user+repo"+"&state=%s";

}
