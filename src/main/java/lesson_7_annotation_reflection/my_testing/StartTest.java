package lesson_7_annotation_reflection.my_testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class StartTest {
    private static Method methodBeforeSuite;
    private static Method methodAfterSuite;
    private static final List<Method> methodsBeforeEach = new ArrayList<>();
    private static final List<Method> methodsTest = new ArrayList<>();

    public static void start(Class<?> clazz) {
        try {
            Object object = clazz.getDeclaredConstructor().newInstance();
            prepareMethods(clazz);
            if (methodBeforeSuite != null) {
                methodBeforeSuite.setAccessible(true);
                methodBeforeSuite.invoke(null);
            }
            methodsTest.sort((a1, a2) -> Integer.compare(a2.getDeclaredAnnotation(Test.class).priority(), a1.getDeclaredAnnotation(Test.class).priority()));
            for (Method method : methodsTest) {
                method.setAccessible(true);
                for (Method methodBeforeEach : methodsBeforeEach) {
                    methodBeforeEach.setAccessible(true);
                    if (Modifier.isStatic(methodBeforeEach.getModifiers())) {
                        methodBeforeEach.invoke(null);
                    } else methodBeforeEach.invoke(object);
                }
                if (Modifier.isStatic(method.getModifiers())) {
                    method.invoke(null);
                } else method.invoke(object);
            }
            if (methodAfterSuite != null) {
                methodAfterSuite.setAccessible(true);
                methodAfterSuite.invoke(null);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("The test class must have a default constructor");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void prepareMethods(Class<?> clazz) {
        int countMethodBeforeSuite = 0, countMethodAfterSuite = 0;
        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method method : allMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (countMethodBeforeSuite == 1 || !Modifier.isStatic(method.getModifiers()))
                    throw new RuntimeException("Methods with annotation BeforeSuite shouldn't be more than one and must be static");
                countMethodBeforeSuite++;
                methodBeforeSuite = method;
                continue;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (countMethodAfterSuite == 1 || !Modifier.isStatic(method.getModifiers()))
                    throw new RuntimeException("Methods with annotation AfterSuite shouldn't be more than one and must be static");
                countMethodAfterSuite++;
                methodAfterSuite = method;
                continue;
            }
            if (method.isAnnotationPresent(Test.class)) methodsTest.add(method);
            if (method.isAnnotationPresent(BeforeEach.class)) methodsBeforeEach.add(method);
        }
    }

}
