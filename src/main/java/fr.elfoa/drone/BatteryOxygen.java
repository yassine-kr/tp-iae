package fr.elfoa.drone;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@RequestScoped
@Oxygen
public class BatteryOxygen implements IBattery {

    private List<Module> modules;

    public BatteryOxygen() {
        modules = Arrays.asList(new Module(),
                new Module(),
                new Module(),
                new Module());
    }

    @Override
    public void use(Integer power) {
        Module module = modules.stream()
                .filter(m -> m.getPower() != 0)
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new);

        module.use((int)(power*1.0/2.0));

    }

    @Override
    public Integer getPower() {
        return modules.stream()
                .mapToInt(Module::getPower)
                .sum();
    }
}
