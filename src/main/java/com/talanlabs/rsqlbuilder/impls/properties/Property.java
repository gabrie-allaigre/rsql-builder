package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public class Property<B> extends AbstractProperty<B> {

    public Property(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }
}
