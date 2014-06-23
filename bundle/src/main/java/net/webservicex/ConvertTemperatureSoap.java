package net.webservicex;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2014-06-23T12:38:47.718+05:30
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://www.webserviceX.NET/", name = "ConvertTemperatureSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface ConvertTemperatureSoap {

    @WebResult(name = "ConvertTempResult", targetNamespace = "http://www.webserviceX.NET/")
    @RequestWrapper(localName = "ConvertTemp", targetNamespace = "http://www.webserviceX.NET/", className = "net.webservicex.ConvertTemp")
    @WebMethod(operationName = "ConvertTemp", action = "http://www.webserviceX.NET/ConvertTemp")
    @ResponseWrapper(localName = "ConvertTempResponse", targetNamespace = "http://www.webserviceX.NET/", className = "net.webservicex.ConvertTempResponse")
    public double convertTemp(
        @WebParam(name = "Temperature", targetNamespace = "http://www.webserviceX.NET/")
        double temperature,
        @WebParam(name = "FromUnit", targetNamespace = "http://www.webserviceX.NET/")
        net.webservicex.TemperatureUnit fromUnit,
        @WebParam(name = "ToUnit", targetNamespace = "http://www.webserviceX.NET/")
        net.webservicex.TemperatureUnit toUnit
    );
}
