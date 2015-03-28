package dk.erikzielke.hockeyapp.idea.task;

import dk.erikzielke.hockeyapp.idea.task.api.CrashReason;
import dk.erikzielke.hockeyapp.idea.task.api.HockeyAppClient;

import java.util.List;

/**
 * Created by Erik on 28-03-2015.
 */
public class Main {
    public static void main(String[] args) {
        HockeyAppClient hockeyAppClient = new HockeyAppClient("c63cdecf002b42189490bc54e49b8557");
            final List<CrashReason> crashGroups = hockeyAppClient.getCrashGroups("88896e92a551fbce6865bc8802058ac4");
        for (CrashReason crashGroup : crashGroups) {
            System.out.println(crashGroup.getReason());
        }
    }
}
