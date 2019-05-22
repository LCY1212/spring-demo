package com.lcy;

import com.lcy.domain.Car1;
import com.lcy.domain.Cars;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Car1 car1 = new Car1();

        Cars car = (Cars) Proxy.newProxyInstance(
                car1.getClass().getClassLoader(),
                car1.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("222222222222222222");
                        return method.invoke(car1,args);
                    }
                }
        );
        car.run();
    }
}
