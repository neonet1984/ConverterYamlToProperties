import com.config.AppConfig;
import com.service.IFileAdapter;
import com.service.IParser;
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
        IFileAdapter fileAdapter = (IFileAdapter) context.getBean("fileAdapterService");
        fileAdapter.init();
        IParser parser = (IParser) context.getBean("parserService");
        fileAdapter.write(parser.getConverterData(fileAdapter.readFile()));
    }

}
