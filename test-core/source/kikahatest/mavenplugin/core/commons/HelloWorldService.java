package kikahatest.mavenplugin.core.commons;


import javax.inject.Singleton;

@Singleton
public class HelloWorldService {
    public String getMessage(final String name) {
        return "Hello " + name + "!";
    }
}
