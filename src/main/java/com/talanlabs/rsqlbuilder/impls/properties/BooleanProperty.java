package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

public class BooleanProperty<B> extends AbstractProperty<B> {

    public BooleanProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    public final B isTrue() {
        return fieldBuilder.eq(field, "true");
    }

    public final B isFalse() {
        return fieldBuilder.eq(field, "false");
    }
}
