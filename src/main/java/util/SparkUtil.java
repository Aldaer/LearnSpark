package util;

import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class SparkUtil {

    private static JavaSparkContext context;

    public static JavaSparkContext getSparkContext() {
        Logger.getLogger("org").setLevel(Level.WARN);
        Logger.getLogger("akka").setLevel(Level.WARN);
        if (context == null) {
            ResourceBundle props = ResourceBundle.getBundle("props");
            if (SystemUtils.IS_OS_WINDOWS) {
                Path path = Paths.get("");
                System.setProperty("hadoop.home.dir", String.valueOf(path.toAbsolutePath()));
            }

            SparkConf conf = new SparkConf()
                    .setAppName(props.getString("appName"))
                    .setMaster(props.getString("master"));
            context = new JavaSparkContext(conf);
        }
        return context;
    }

}
