package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public class StringProperty<B> extends AbstractListableProperty<B, String> {

    public StringProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    /**
     * Start with, add wildcard to end value*
     */
    public B startWith(String value) {
        return eq((value != null ? value : "") + "*");
    }

    /**
     * End with, add wildcard to start *value
     */
    public B endWith(String value) {
        return eq("*" + (value != null ? value : ""));
    }

    /**
     * Contains, add wildcard to stard and end *value*
     */
    public B contains(String value) {
        return eq("*" + (value != null ? value : "") + "*");
    }

    @Override
    protected String toString(String value) {
        return "'" + (value != null ? value.replaceAll("'", "\\\\'") : "") + "'";
    }
}