import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;

public class pushToHelios extends DefaultTask {
    String[] files = new String[] {"text", "231"};

    @TaskAction
    public void transferToHelios(){
        try {
            var project = "Lab2";
            var server = "s367379@se.ifmo.ru";
            var folder = "~/labs/programming";

            var mkdir = String.format("mkdir " + project);
            var transfer = String.format("scp -r -P 2222 %s %s:%s", project, server, folder);
            //var remove = String.format("rm -r " + project);

            execute(mkdir);
            for (String file : files){
                copyToFolder(file, project);
            }
            execute(transfer);
            //execute(remove);

        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void copyToFolder(String file, String project) throws IOException, InterruptedException {
        var copy = String.format("cp -r %s %s/", file, project);
        execute(copy);
    }

    private static void execute(String command) throws InterruptedException, IOException {
        Runtime.getRuntime().exec(command);
        Thread.sleep(200);
    }
}

