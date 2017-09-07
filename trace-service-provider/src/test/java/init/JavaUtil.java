package init;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaUtil {

    public static void compile() {
        execCMD();
    }

    public static void execCMD() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("cd .. && mvn compile -Dmaven.test.skip=true");

            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
