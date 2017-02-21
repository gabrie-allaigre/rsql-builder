package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public abstract class AbstractNumberProperty<B, T extends Number> extends AbstractListableProperty<B, T> {

    AbstractNumberProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    /**
     * Less to, use ==lt==
     *
     * @param value number
     */
    public final B lt(T value) {
        return fieldBuilder.lt(field, toString(value));
    }

    /**
     * Less or equals, use ==le==
     *
     * @param value number
     */
    public final B lte(T value) {
        return fieldBuilder.lte(field, toString(value));
    }

    /**
     * Greater to, use ==gt==
     *
     * @param value number
     */
    public final B gt(T value) {
        return fieldBuilder.gt(field, toString(value));
    }

    /**
     * Greater or equals, use ==ge==
     *
     * @param value number
     */
    public final B gte(T value) {
        return fieldBuilder.gte(field, toString(value));
    }
}
