/*
 * Led Controller for a single GPIO
 */
package com.amazon.alexa.avs.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LedController {

    private final GpioController gpio;
    private final GpioPinDigitalOutput ledPin;
    private final Pin pin;
    
    public LedController(Pin pin) {
        this.pin = pin;

        this.gpio = GpioFactory.getInstance();
        this.ledPin = gpio.provisionDigitalOutputPin(this.pin, "MyLED", PinState.LOW);
        // set shutdown state for this pin
        this.ledPin.setShutdownOptions(true, PinState.LOW);
        this.ledPin.pulse(1000, false);
    }
  
    /**
     * Turn on the led
     */
    public void turnOn() {
       this.ledPin.high();
    }
    
    /**
     * Turn off the led
     */
    public void turnOff() {
       this.ledPin.low();
    }
    
//    public static void main(String[] args) {
//        try {
//           LedController led = new LedController(RaspiPin.GPIO_00);
//           led.turnOn();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
// }
       
}
