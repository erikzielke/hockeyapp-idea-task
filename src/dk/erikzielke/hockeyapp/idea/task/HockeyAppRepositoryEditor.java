package dk.erikzielke.hockeyapp.idea.task;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.tasks.config.TaskRepositoryEditor;
import com.intellij.ui.DocumentAdapter;
import com.intellij.util.Consumer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;

public class HockeyAppRepositoryEditor extends TaskRepositoryEditor {
    private JPanel rootPanel;
    private JTextField apiKey;
    private JTextField textField1;
    private Project project;
    private HockeyAppRepository repository;
    private Consumer<HockeyAppRepository> consumer;
    private boolean myApplying;

    public HockeyAppRepositoryEditor(Project project, HockeyAppRepository repository, Consumer<HockeyAppRepository> consumer) {
        this.project = project;
        this.repository = repository;
        this.consumer = consumer;
        apiKey.setText(repository.getApiKey());
        textField1.setText(repository.getAppId());
        installListener(textField1);
        installListener(apiKey);
    }

    public void apply() {
        this.repository.setApiKey(this.apiKey.getText());
        this.repository.setAppId(this.textField1.getText());
        consumer.consume(repository);
    }

    protected void installListener(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(DocumentEvent e) {
                ApplicationManager.getApplication().invokeLater(new Runnable() {
                    public void run() {
                        doApply();
                    }
                });
            }
        });
    }

    protected void doApply() {
        if (!myApplying) {
            try {
                myApplying = true;
                apply();
//                enableEditor();
            }
            finally {
                myApplying = false;
            }
        }
    }



    @Override
    public JComponent createComponent() {
        return rootPanel;
    }
}
