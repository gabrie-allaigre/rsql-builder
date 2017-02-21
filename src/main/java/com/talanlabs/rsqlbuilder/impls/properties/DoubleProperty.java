package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public class DoubleProperty<B> extends AbstractNumberProperty<B, Double> {

    public DoubleProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    @Override
    protected String toString(Double value) {
        return value != null ? value.toString() : "";
    }
}