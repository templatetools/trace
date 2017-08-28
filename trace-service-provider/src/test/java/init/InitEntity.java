package init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2x.POJOExporter;
import org.junit.Test;

import java.io.File;

/**
 * Created by tom on 2017/8/25.
 */
public class InitEntity {
    public static final String PROJCET_PATH = "/work/001_code/github/java/trace/trace-service-provider/";
    public static final String OUTPUT_DIR = PROJCET_PATH + "src/main/java";
    public static final String TARGET_DIR = PROJCET_PATH + "target/classes";

    @Test
    public void init(){
        Configuration configuration = new Configuration().configure();

        POJOExporter exporter = new POJOExporter();
        exporter.setConfiguration(configuration);
        exporter.setOutputDirectory(new File(OUTPUT_DIR));
        exporter.getProperties().setProperty("ejb3", "true");
        exporter.start();

//        JavaUtil.compile(new File(OUTPUT_DIR), new File(TARGET_DIR),ImmutableList.of("/work/001_code/github/java/trace/trace-rest-provider/target/trace-rest-provider-1.0-SNAPSHOT.jar"));

        configuration.buildSessionFactory();
    }
}
