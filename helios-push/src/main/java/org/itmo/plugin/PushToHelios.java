package org.itmo.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;

public class PushToHelios extends DefaultTask {
    String[] files = new String[0];
    String projectName = "project";
    String isu = "367379";
    String folderPath = "~/labs/programming";
    int waitingTime = 200;

    @TaskAction
    public void transferToHelios() throws IOException {
        try {
            var server = String.format("s%s@se.ifmo.ru", isu);

            var mkdir = String.format("mkdir -p tmp/" + projectName);
            var transfer = String.format("scp -r -P 2222 tmp/%s %s:%s", projectName, server, folderPath);

            execute(mkdir);
            for (String file : files){
                copyToFolder(file, projectName);
            }
            execute(transfer);

        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void copyToFolder(String file, String project) throws IOException, InterruptedException {
        var copy = String.format("cp -r %s tmp/%s/", file, project);
        execute(copy);
    }

    private void execute(String command) throws InterruptedException, IOException {
        Runtime.getRuntime().exec(command);
        Thread.sleep(waitingTime);
    }
}


