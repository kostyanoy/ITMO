import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class Helios implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create("helios", pushToHelios.class);
    }
}
