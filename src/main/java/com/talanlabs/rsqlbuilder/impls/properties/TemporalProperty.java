package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

import java.time.temporal.Temporal;

public class TemporalProperty<B, T extends Temporal> extends AbstractEquitableProperty<B, T> {

    public TemporalProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    @Override
    protected String toString(T value) {
        return "'" + (value != null ? value.toString().replaceAll("'", "\\\\'") : "") + "'";
    }

    /**
     * Less to, use ==lt==
     *
     * @param value     temporal value
     * @param exclusive
     */
    public final B before(T value, boolean exclusive) {
        return exclusive ? fieldBuilder.lt(field, toString(value)) : fieldBuilder.lte(field, toString(value));
    }

    /**
     * Less or equals, use ==le==
     *
     * @param value     temporal value
     * @param exclusive
     */
    public final B after(T value, boolean exclusive) {
        return exclusive ? fieldBuilder.gt(field, toString(value)) : fieldBuilder.gte(field, toString(value));
    }
}
