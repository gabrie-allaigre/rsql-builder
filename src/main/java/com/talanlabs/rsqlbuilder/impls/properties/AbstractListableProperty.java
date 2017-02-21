package com.talanlabs.rsqlbuilder.impls.properties;

import com.talanlabs.rsqlbuilder.impls.AbstractField;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractListableProperty<B, T> extends AbstractEquitableProperty<B, T> {

    AbstractListableProperty(String field, AbstractField<B> fieldBuilder) {
        super(field, fieldBuilder);
    }

    /**
     * In, use ==in==
     *
     * @param values arrays of type
     */
    public final B in(T... values) {
        return in(Arrays.asList(values));
    }

    /**
     * In, use ==in==
     *
     * @param values collection of type
     */
    public final B in(Collection<T> values) {
        return fieldBuilder.in(field, toString(values));
    }

    /**
     * Not in, use ==out==
     *
     * @param values arrays of type
     */
    public final B nin(T... values) {
        return nin(Arrays.asList(values));
    }

    /**
     * Not in, use ==out==
     *
     * @param values collection of type
     */
    public final B nin(Collection<T> values) {
        return fieldBuilder.nin(field, toString(values));
    }

    private String toString(Collection<T> values) {
        return values.stream().map(this::toString).collect(Collectors.joining(",", "(", ")"));
    }
}
