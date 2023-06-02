package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public abstract class AbstractProperty<B> {

    protected final String field;
    protected final AbstractField<B> fieldBuilder;

    AbstractProperty(String field, AbstractField<B> fieldBuilder) {
        super();

        this.field = field;
        this.fieldBuilder = fieldBuilder;
    }

    public final B isNull() {
        return fieldBuilder.isNull(field);
    }
}
