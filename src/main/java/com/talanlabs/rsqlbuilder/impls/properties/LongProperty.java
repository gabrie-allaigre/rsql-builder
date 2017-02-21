package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public class LongProperty<B> extends AbstractNumberProperty<B, Long> {

    public LongProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    @Override
    protected String toString(Long value) {
        return value != null ? value.toString() : "";
    }
}