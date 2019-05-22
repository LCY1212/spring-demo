package com.lcy;

import com.lcy.domain.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglibtest {
    public static void main(String[] args) {
        final Car car = new Car();

        Car o = (Car) Enhancer.create(
                car.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        System.out.println("1111111");

                        return method.invoke(car, args);
                    }
                }
        );
        o.run();
    }
}
