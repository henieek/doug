package com.github.partition.doug;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Provider;

final class Doug {

    static void mock(Object component, Object mock) {
        mock(component, mock, getMockClass(mock));
    }

    static void mock(Object component, Object mock, Class<?> mappingClass) {
        try {
            mockInternal(new HashSet<Class<?>>(), component, mock, mappingClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void mockInternal(Set<Class<?>> alreadyMocked, Object objectToMock, final Object mock, Class<?> mappingClass)
            throws IllegalAccessException {
        if (objectToMock == null || alreadyMocked.contains(objectToMock.getClass())) {
            return;
        }
        alreadyMocked.add(objectToMock.getClass());
        for (Field field : objectToMock.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (normalizeDaggerFieldName(field).equals(mappingClass.getSimpleName())) {
                field.set(objectToMock, createMockProvider(mock));
            } else {
                mockInternal(alreadyMocked, field.get(objectToMock), mock, mappingClass);
            }
            field.setAccessible(false);
        }
    }

    private static Provider createMockProvider(final Object mock) {
        return new Provider() {
            @Override
            public Object get() {
                return mock;
            }
        };
    }

    private static Class<?> getMockClass(Object object) {
        return object.getClass().getSuperclass();
    }

    private static String normalizeDaggerFieldName(Field daggerField) {
        String withoutProvider = daggerField
                .getName()
                .replace("Provider", "");

        return capitalize(withoutProvider);
    }

    private static String capitalize(String withoutProvider) {
        return withoutProvider.substring(0, 1).toUpperCase() + withoutProvider.substring(1);
    }

    private Doug() {
    }
}
