package com.ig.util;

import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class JaxWsClientFactory {

    private JaxWsClientFactory() { /* NO CONSTRUCTOR */}

    public static <T> T create(Class<T> ParentClass, String portUrl) {
        ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(BusFactory.class.getClassLoader());
        try {
            return JaxWsClientFactory.create(ParentClass, portUrl, null, null);
        } finally {
            Thread.currentThread().setContextClassLoader(oldClassLoader);
        }
    }

    public static <T> T create(Class<T> ParentClass, String portUrl, String userName, String password) {

        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        try {
            jaxWsProxyFactoryBean.setServiceClass(ParentClass);
            jaxWsProxyFactoryBean.setAddress(portUrl);
            jaxWsProxyFactoryBean.setUsername(userName);
            jaxWsProxyFactoryBean.setPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) jaxWsProxyFactoryBean.create();
    }
}
