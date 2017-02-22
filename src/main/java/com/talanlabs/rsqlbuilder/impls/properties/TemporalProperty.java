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
     * Before temporal, use ==lt== or ==le== (include)
     *
     * @param value   temporal value
     * @param include include value <=
     */
    public final B before(T value, boolean include) {
        return include ? fieldBuilder.lte(field, toString(value)) : fieldBuilder.lt(field, toString(value));
    }

    /**
     * After temporal, use ==gt== or ==ge== (include)
     *
     * @param value   temporal value
     * @param include include value <=
     */
    public final B after(T value, boolean include) {
        return include ? fieldBuilder.gte(field, toString(value)) : fieldBuilder.gt(field, toString(value));
    }
}
