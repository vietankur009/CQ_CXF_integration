package com.ig.integration.impl;

import com.ig.integration.ConvertTemperatureService;
import com.ig.util.JaxWsClientFactory;
import net.webservicex.ConvertTemperatureSoap;
import net.webservicex.TemperatureUnit;
import org.apache.cxf.BusFactory;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;

@Service
@Component(immediate = true,metatype = false,enabled = true)
public class ConvertTemperatureImpl implements ConvertTemperatureService{
    private ConvertTemperatureSoap convertTemperatureSoap;

    @Override
    public double convertCelsiusToFahrenheit(double valueToConvert) {
        double convertedTemperature = 0.0;
        try {
            convertTemperatureSoap = JaxWsClientFactory.create(ConvertTemperatureSoap.class,
                    "http://www.webservicex.net/ConvertTemperature.asmx");
            convertedTemperature = convertTemperatureSoap.convertTemp(valueToConvert,
                    TemperatureUnit.DEGREE_CELSIUS, TemperatureUnit.DEGREE_FAHRENHEIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertedTemperature;
    }

    public ConvertTemperatureSoap getInstance() {
        return convertTemperatureSoap;
    }

    @Activate
    protected void activate(final ComponentContext componentContext) {
        System.out.println("inside activate method");
    }
}
