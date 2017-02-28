package challenges;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * Created by saradion on 17/01/17.
 */
public class CompiLoader {
    public static Class<?> compileAndLoad(String fileURI, String classURI) {
        File helloWorldJava = new File(fileURI);
        if (helloWorldJava.getParentFile().exists() || helloWorldJava.getParentFile().mkdirs()) {

            try {
                /** Compilation Requirements *********************************************************************************************/
                DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

                // This sets up the class path that the compiler will use.
                // I've added the .jar file that contains the DoStuff interface within in it...
                List<String> optionList = new ArrayList<String>();
                optionList.add("-classpath");
                optionList.add(System.getProperty("java.class.path") + ";dist/Chall1.jar");

                Iterable<? extends JavaFileObject> compilationUnit
                        = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
                JavaCompiler.CompilationTask task = compiler.getTask(
                        null,
                        fileManager,
                        diagnostics,
                        optionList,
                        null,
                        compilationUnit);

                if (task.call()) {
                    // Create a new custom class loader, pointing to the directory that contains the compiled
                    // classes, this should point to the top of the package structure!
                    URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("/tmp/mathias/").toURI().toURL()});
                    // Load the class from the classloader by name....
                    Class<?> myClass = classLoader.loadClass(classURI);
                    System.out.println(myClass);
                    return myClass;
                } else {
                    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                        System.out.format("Error on line %d in %s%n",
                                diagnostic.getLineNumber(),
                                diagnostic.getSource().toUri());
                    }
                }
                fileManager.close();
            } catch (IOException | ClassNotFoundException exp) {
                exp.printStackTrace();
            }
        }
        return null;
    }
}
