//package com.example.onlineorders.service;
//
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.ParameterContext;
//import org.junit.jupiter.api.extension.ParameterResolutionException;
//import org.junit.jupiter.api.extension.ParameterResolver;
//
//import java.util.Objects;
//
//public class ServiceClientsRunTest implements ParameterResolver {
//    @Override
//    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//        return parameterContext.isAnnotated(ServiceInject.class) && parameterContext.getParameter().getType() == ClientsService.class;
//    }
//
//    @Override
//    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//        String value=parameterContext.getParameter().getAnnotation(ServiceInject.class).value();
//        return Objects.requireNonNull(ServiceClientsRunTest.class.getClassLoader().getResource(value).toString());
//
//    }
//}
