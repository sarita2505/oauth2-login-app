package com.java.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HttpUtils {
    public static Response sendPost(String url, Map<String, String> postDataMap) throws Exception {

        OkHttpClient httpClient = new OkHttpClient();
        // form parameters
        RequestBody formBody = null;

        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : postDataMap.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        formBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                //.addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println("ACCESS TOKEN RESPONSE: "+response.body().string());
            return response;
        }
    }
}
