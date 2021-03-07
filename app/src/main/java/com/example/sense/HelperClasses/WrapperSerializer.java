package com.example.sense.HelperClasses;

import java.io.Serializable;

public class WrapperSerializer <T extends Serializable> implements Serializable {
    private T wrapped;

    public WrapperSerializer(T wrapped) {
        this.wrapped = wrapped;
    }

    public T get() {
        return wrapped;
    }
}