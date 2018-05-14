package registry;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class DependencyRegistry {
    private static Injector injector;

    public static Injector boot() {
        if (injector == null) {
            injector = Guice.createInjector(ModuleProvider.getModules());
        }

        return injector;
    }
}
