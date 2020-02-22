package util;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@SuppressWarnings("rawtypes")
public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
    }

    /**
     * This open a file that resides in resources at the same package as the calling class.
     * There is no exception if the file does not exist, an empty {@link InputStream} will be returned
     *
     * @param filename the name of the file that we want to open, no '/' or '\' is needed
     * @param clazz    the calling class, in order to get the package
     * @return the input stream of the file
     */
    @NonNull
    public static InputStream getFileFromResources(String filename, Class clazz) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(clazz.getPackage().getName() + "/" + filename);
    }

    /**
     * This writes to a file that resides in resources at the same package as the calling class.
     * If the file does not exist it will be created. If it exists it will be overwritten.
     *
     * @param sb       string builder to be written
     * @param filename the name of the file that we want to write on, no '/' or '\' is needed
     * @param clazz    the calling class, in order to get the package
     */
    public static void writeToFile(StringBuilder sb, String filename, Class clazz) {
        writeToFile(sb.toString(), filename, clazz);
    }

    /**
     * This writes to a file that resides in resources at the same package as the calling class.
     * If the file does not exist it will be created. If it exists it will be overwritten.
     *
     * @param str      string to be written to file
     * @param filename the name of the file that we want to write on, no '/' or '\' is needed
     * @param clazz    the calling class, in order to get the package
     */
    public static void writeToFile(String str, String filename, Class clazz) {
        Path path = Paths.get(getFileOrDirFromResources(clazz.getPackage().getName(), clazz).toString(), filename);

        try {
            Files.write(path, str.getBytes(), CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
    }

    @NonNull
    private static Path getFileOrDirFromResources(String s, Class clazz) {
        try {
            return Paths.get(Objects.requireNonNull(clazz.getClassLoader().getResource(s)).toURI());
        } catch (URISyntaxException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        throw new NoSuchElementException(MessageFormat.format("The directory: {} was not found", s));
    }
}
