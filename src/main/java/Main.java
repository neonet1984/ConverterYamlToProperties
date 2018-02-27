import com.application.Application;
import com.config.ConfigurationApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApp.class);
        Application application =(Application) context.getBean("applicationService");
        application.startup();
    }

}
