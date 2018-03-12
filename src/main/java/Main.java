import com.config.AppConfig;
import com.service.IStartup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * The class launches the application
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * App Entry Point applicaton
     */
    public static void main(String[] args) {
        log.info("Application started");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IStartup startupApplication = (IStartup) context.getBean("startupService");
        startupApplication.startup();
    }
}
