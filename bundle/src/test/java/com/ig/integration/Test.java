package com.ig.integration;


import com.ig.util.JaxWsClientFactory;
import net.webservicex.ConvertTemperatureSoap;
import net.webservicex.TemperatureUnit;
import org.apache.cxf.BusFactory;

public class Test {
    private static ConvertTemperatureSoap convertTemperatureSoap;
    public static void main(String... arg){
        double convertedTemperature = 0.0;
        try {
            convertTemperatureSoap = JaxWsClientFactory.create(ConvertTemperatureSoap.class,"http://www.webservicex.net/ConvertTemperature.asmx");
            convertedTemperature = convertTemperatureSoap.convertTemp(200,
                    TemperatureUnit.DEGREE_CELSIUS, TemperatureUnit.DEGREE_FAHRENHEIT);
            System.out.println("converted temperature = "+convertedTemperature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
