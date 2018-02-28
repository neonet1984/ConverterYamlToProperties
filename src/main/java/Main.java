import com.service.IStartup;
import com.config.AppConfig;
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
        IStartup IStartup = (IStartup) context.getBean("startupService");
        IStartup.startup();
    }

}
