package dk.erikzielke.hockeyapp.idea.task.api;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Crash {
    long id;
    @SerializedName("app_id")
    long appId;
    @SerializedName("app_version_id")
    long appVersionId;
    @SerializedName("crash_reason_id")
    long crashReasonId;
    @SerializedName("createdAt")
    Date created_at;
    @SerializedName("updatedAt")
    Date updated_at;
    @SerializedName("oem")
    String oem;
    @SerializedName("model")
    String model;
    @SerializedName("bundleVersion")
    String bundleVersion;
    @SerializedName("bundleShortVersion")
    String bundleShortVersion;
    @SerializedName("contact_string")
    String contactString;
    @SerializedName("user_string")
    String userString;
    @SerializedName("os_version")
    String osVersion;
    @SerializedName("jail_break")
    boolean jailBreak;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getAppVersionId() {
        return appVersionId;
    }

    public void setAppVersionId(long appVersionId) {
        this.appVersionId = appVersionId;
    }

    public long getCrashReasonId() {
        return crashReasonId;
    }

    public void setCrashReasonId(long crashReasonId) {
        this.crashReasonId = crashReasonId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBundleVersion() {
        return bundleVersion;
    }

    public void setBundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    public String getBundleShortVersion() {
        return bundleShortVersion;
    }

    public void setBundleShortVersion(String bundleShortVersion) {
        this.bundleShortVersion = bundleShortVersion;
    }

    public String getContactString() {
        return contactString;
    }

    public void setContactString(String contactString) {
        this.contactString = contactString;
    }

    public String getUserString() {
        return userString;
    }

    public void setUserString(String userString) {
        this.userString = userString;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public boolean isJailBreak() {
        return jailBreak;
    }

    public void setJailBreak(boolean jailBreak) {
        this.jailBreak = jailBreak;
    }
}
