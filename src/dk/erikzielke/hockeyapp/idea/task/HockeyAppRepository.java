package dk.erikzielke.hockeyapp.idea.task;

import com.intellij.tasks.*;
import com.intellij.tasks.impl.BaseRepository;
import com.intellij.tasks.impl.BaseRepositoryImpl;
import com.intellij.util.xmlb.annotations.Attribute;
import com.intellij.util.xmlb.annotations.Tag;
import dk.erikzielke.hockeyapp.idea.icons.HockeyAppIcons;
import dk.erikzielke.hockeyapp.idea.task.api.Crash;
import dk.erikzielke.hockeyapp.idea.task.api.CrashReason;
import dk.erikzielke.hockeyapp.idea.task.api.HockeyAppClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Tag("hockey")
public class HockeyAppRepository extends BaseRepositoryImpl {
    @Attribute
    private String apiKey;
    @Attribute
    private String appId;

    public String getApiKey() {
        return apiKey;

    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public HockeyAppRepository() {
        super();
        setUrl("http://rink.hockeyapp.net");
    }

    public HockeyAppRepository(TaskRepositoryType type) {
        super(type);
        setUrl("http://rink.hockeyapp.net");
    }

    public HockeyAppRepository(BaseRepositoryImpl other) {
        super(other);
        setUrl("http://rink.hockeyapp.net");
    }

    @Nullable
    @Override
    public Task findTask(@NotNull String s) throws Exception {
        return null;
    }

    @NotNull
    @Override
    public BaseRepository clone() {
        final HockeyAppRepository hockeyAppRepository = new HockeyAppRepository(getRepositoryType());
        hockeyAppRepository.setUrl(getUrl());
        hockeyAppRepository.setApiKey(apiKey);
        hockeyAppRepository.setAppId(appId);
        return hockeyAppRepository;
    }


    @Override
    public Task[] getIssues(@Nullable String query, int max, long since) throws Exception {
        HockeyAppClient hockeyAppClient = new HockeyAppClient(apiKey);
        final List<CrashReason> crashGroups = hockeyAppClient.getCrashGroups(appId);
        List<Task> tasks = new ArrayList<>();
        for (final CrashReason crashGroup : crashGroups) {
            final List<Crash> crashesForReason = hockeyAppClient.getCrashesForReason(appId, crashGroup);
            String stacktrace = null;
            if (!crashesForReason.isEmpty()) {
                final Crash crash = crashesForReason.get(0);
                stacktrace = hockeyAppClient.getStacktrace(appId, crash);
            }
            final HockeyAppTask hockeyAppTask = new HockeyAppTask(crashGroup, stacktrace);
            tasks.add(hockeyAppTask);
        }
        return tasks.toArray(new Task[tasks.size()]);
    }

    @Nullable
    private Task createTask(final String ID, final String Title, final String Description) {

        return new Task() {
            @Override
            public boolean isIssue() {
                return true;
            }

            @Nullable
            @Override
            public String getIssueUrl() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }


            @NotNull
            @Override
            public String getId() {
                return ID;
            }

            @NotNull
            @Override
            public String getSummary() {
                return Title;
            }

            public String getDescription() {
                return Description;
            }

            @NotNull
            @Override
            public Comment[] getComments() {
                return new Comment[0];
            }

            @NotNull
            @Override
            public Icon getIcon() {
                return HockeyAppIcons.HockeyAppIcon;
            }

            @NotNull
            @Override
            public TaskType getType() {
                return TaskType.OTHER;
            }

            @Nullable
            @Override
            public Date getUpdated() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Nullable
            @Override
            public Date getCreated() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isClosed() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }


            @Override
            public TaskRepository getRepository() {
                return HockeyAppRepository.this;
            }

            @Override
            public String getPresentableName() {
                return getId() + ": " + getSummary();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof HockeyAppRepository)) return false;

        HockeyAppRepository that = (HockeyAppRepository) o;
        return true;
    }

    private static class HockeyAppTask extends Task {
        private final CrashReason crashGroup;
        private String stacktrace;

        public HockeyAppTask(CrashReason crashGroup, String stacktrace) {
            this.crashGroup = crashGroup;
            this.stacktrace = stacktrace;
        }

        @NotNull
        @Override
        public String getId() {
            return String.valueOf(crashGroup.getId());
        }

        @NotNull
        @Override
        public String getSummary() {
            return crashGroup.getReason();
        }

        @Nullable
        @Override
        public String getDescription() {
            return stacktrace;
        }

        @NotNull
        @Override
        public Comment[] getComments() {
            return new Comment[0];
        }

        @NotNull
        @Override
        public Icon getIcon() {
            return HockeyAppIcons.HockeyAppIcon;
        }

        @NotNull
        @Override
        public TaskType getType() {
            return TaskType.EXCEPTION;
        }

        @Nullable
        @Override
        public Date getUpdated() {
            return crashGroup.getUpdatedAt();
        }

        @Nullable
        @Override
        public Date getCreated() {
            return crashGroup.getCreatedAt();
        }

        @Override
        public boolean isClosed() {
            return false;
        }

        @Override
        public boolean isIssue() {
            return false;
        }

        @Nullable
        @Override
        public String getIssueUrl() {
            return "https://rink.hockeyapp.net/manage/apps/" + crashGroup.getAppId() + "/crash_reasons/" + crashGroup.getId();
        }
    }
}
