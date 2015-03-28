package dk.erikzielke.hockeyapp.idea.task;

import com.intellij.openapi.project.Project;
import com.intellij.tasks.TaskRepository;
import com.intellij.tasks.TaskRepositoryType;
import com.intellij.tasks.TaskState;
import com.intellij.tasks.config.BaseRepositoryEditor;
import com.intellij.tasks.config.TaskRepositoryEditor;
import com.intellij.util.Consumer;
import dk.erikzielke.hockeyapp.idea.icons.HockeyAppIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.EnumSet;

public class HockeyAppRepositoryType extends TaskRepositoryType<HockeyAppRepository>  {


    @NotNull
    @Override
    public String getName() {
        return "HockeyApp";
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return HockeyAppIcons.HockeyAppIcon;
    }

    @NotNull
    @Override
    public TaskRepositoryEditor createEditor(HockeyAppRepository hockeyAppRepository, Project project, Consumer<HockeyAppRepository> consumer) {
        return new HockeyAppRepositoryEditor(project, hockeyAppRepository, consumer);
    }

    @NotNull
    @Override
    public TaskRepository createRepository() {
        return new HockeyAppRepository(this);
    }

    @Override
    public Class<HockeyAppRepository> getRepositoryClass() {
        return HockeyAppRepository.class;
    }


    @Override
    public EnumSet<TaskState> getPossibleTaskStates() {
        return EnumSet.of(TaskState.OPEN, TaskState.RESOLVED, TaskState.OTHER);
    }


}
