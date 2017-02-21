package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public class ShortProperty<B> extends AbstractNumberProperty<B, Short> {

    public ShortProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    @Override
    protected String toString(Short value) {
        return value != null ? value.toString() : "";
    }
}