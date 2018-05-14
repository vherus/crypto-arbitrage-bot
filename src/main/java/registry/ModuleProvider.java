package registry;

import com.google.inject.Module;
import command.CommandBusModule;
import common.ComponentModule;

import java.util.LinkedList;
import java.util.List;

final class ModuleProvider {
    static List<Module> getModules() {
        List<Module> modules = new LinkedList<>();

        modules.add(new CommandBusModule());
        modules.add(new ComponentModule());

        return modules;
    }
}
