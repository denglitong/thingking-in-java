package com.denglitong.controller;

/**
 * 这是命令设计模式的一个例子 - events中的每个对象都被封装成对象的请求
 *
 * @autor denglitong
 * @date 2019/8/5
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatNight(1400),
        };
        gc.addEvent(gc.new Restart(2000, events));
        gc.addEvent(new GreenhouseControls.Terminate(5000));
        gc.run();
    }
}
