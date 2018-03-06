import com.config.AppConfig;
import com.service.IStartup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * The class launches the application
 */
public class Main {
    /**
     * App Entry Point applicaton
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IStartup startupApplication = (IStartup) context.getBean("startupService");
        startupApplication.startup();
    }
}
