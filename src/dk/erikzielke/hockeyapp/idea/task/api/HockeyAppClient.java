package dk.erikzielke.hockeyapp.idea.task.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik on 28-03-2015.
 */
public class HockeyAppClient {
    private String apiToken;
    private String baseUrl = "https://rink.hockeyapp.net";


    public HockeyAppClient(String apiToken) {
        this.apiToken = apiToken;
    }
    public HockeyAppClient(String apiToken, String baseUrl) {
        this(apiToken);
        this.baseUrl = baseUrl;
    }

    public List<CrashReason> getCrashGroups(String appId) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder requestBuilder = new Request.Builder();
            final String url = baseUrl + MessageFormat.format("/api/2/apps/{0}/crash_reasons", appId);
            final Request request = requestBuilder.get().url(url)
                    .header("X-HockeyAppToken", apiToken)
                    .build();
            final Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'").create();
                final CrashReasonResult crashReasonResult = gson.fromJson(new InputStreamReader(response.body().byteStream()), CrashReasonResult.class);
                return crashReasonResult.getCrashReasons();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<CrashReason>();
    }

    public List<Crash> getCrashesForReason(String appId, CrashReason crashReason) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder requestBuilder = new Request.Builder();
            final String url = baseUrl + MessageFormat.format("/api/2/apps/{0}/crash_reasons/{1}", appId, String.valueOf(crashReason.getId()));
            final Request request = requestBuilder.get().url(url)
                    .header("X-HockeyAppToken", apiToken)
                    .build();
            final Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'").create();
                final CrashResult crashResult = gson.fromJson(new InputStreamReader(response.body().byteStream()), CrashResult.class);
                return crashResult.getCrashes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Crash>();
    }

    public String getStacktrace(String appId, Crash crash) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder requestBuilder = new Request.Builder();
            final String url = baseUrl + MessageFormat.format("/api/2/apps/{0}/crashes/{1}?format=log", appId, String.valueOf(crash.getId()));
            final Request request = requestBuilder.get().url(url)
                    .header("X-HockeyAppToken", apiToken)
                    .build();
            final Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                final String string = response.body().string();
                return string;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
