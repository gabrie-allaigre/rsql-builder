package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public abstract class AbstractEquitableProperty<B, T> extends AbstractProperty<B> {

    AbstractEquitableProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    /**
     * Equal compare, use ==
     *
     * @param value value of type
     */
    public final B eq(T value) {
        return fieldBuilder.eq(field, toString(value));
    }

    /**
     * Not equal, use !=
     *
     * @param value value of type
     */
    public final B neq(T value) {
        return fieldBuilder.neq(field, toString(value));
    }

    protected abstract String toString(T value);

}
