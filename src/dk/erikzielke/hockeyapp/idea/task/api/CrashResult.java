package dk.erikzielke.hockeyapp.idea.task.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CrashResult {
    private List<Crash> crashes;
    @SerializedName("total_entries")
    private int totalEntries;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("per_page")
    private int perPage;
    private String status;
    @SerializedName("current_page")
    private int currentPage;

    public List<Crash> getCrashes() {
        return crashes;
    }

    public void setCrashes(List<Crash> crashes) {
        this.crashes = crashes;
    }

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
