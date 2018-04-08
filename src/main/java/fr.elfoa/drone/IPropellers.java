package fr.elfoa.drone;

public interface IPropellers {
    IBattery getBattery();
    ConsumptionCalculator getCalculator();
    void start();
    void stop();
    Integer getNumberOfPropelle();
    Boolean getRunning();

}
