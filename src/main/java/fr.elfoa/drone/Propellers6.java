package fr.elfoa.drone;

import javax.inject.Inject;
import javax.inject.Qualifier;

@Six
public class Propellers6 implements IPropellers{

    private Integer number = 6;

    private IBattery battery;

    @Inject
    private ConsumptionCalculator calculator;

    private Boolean isRunning = false;

    @Inject
    public Propellers6(@Ion IBattery battery){
        this.battery = battery;
    }

    public IBattery getBattery() {
        return battery;
    }

    public ConsumptionCalculator getCalculator() {
        return calculator;
    }

    public void start(){
        battery.use(calculator.getConsumption(number));
        isRunning = true;
    }

    public void stop(){
        isRunning = false;
    }


    public Integer getNumberOfPropelle() {
        return number;
    }



    public Boolean getRunning() {
        return isRunning;
    }
}
