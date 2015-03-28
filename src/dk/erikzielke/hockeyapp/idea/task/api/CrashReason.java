package dk.erikzielke.hockeyapp.idea.task.api;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CrashReason {
    long id;
    @SerializedName("app_id")
    long appId;

    @SerializedName("app_version_id")
    long appVersionId;

    @SerializedName("number_of_crashes")
    long numberOfCrashes;

    @SerializedName("created_at")
    Date createdAt;

    @SerializedName("updated_at")
    Date updatedAt;

    @SerializedName("last_crash_at")
    Date lastCrashAt;

    @SerializedName("bundle_short_version")
    String bundleShortVersion;

    @SerializedName("bundle_version")
    String bundleVersion;
    String status;
    String fixed;
    String file;

    @SerializedName("class")
    String className;
    String method;
    String line;
    String reason;

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

    public long getNumberOfCrashes() {
        return numberOfCrashes;
    }

    public void setNumberOfCrashes(long numberOfCrashes) {
        this.numberOfCrashes = numberOfCrashes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getLastCrashAt() {
        return lastCrashAt;
    }

    public void setLastCrashAt(Date lastCrashAt) {
        this.lastCrashAt = lastCrashAt;
    }

    public String getBundleShortVersion() {
        return bundleShortVersion;
    }

    public void setBundleShortVersion(String bundleShortVersion) {
        this.bundleShortVersion = bundleShortVersion;
    }

    public String getBundleVersion() {
        return bundleVersion;
    }

    public void setBundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
