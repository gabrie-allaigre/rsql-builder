package com.talanlabs.rsqlbuilder.impls;

import com.talanlabs.rsqlbuilder.RsqlBuilder;
import com.talanlabs.rsqlbuilder.impls.properties.BooleanProperty;
import com.talanlabs.rsqlbuilder.impls.properties.DoubleProperty;
import com.talanlabs.rsqlbuilder.impls.properties.EnumProperty;
import com.talanlabs.rsqlbuilder.impls.properties.FloatProperty;
import com.talanlabs.rsqlbuilder.impls.properties.IntegerProperty;
import com.talanlabs.rsqlbuilder.impls.properties.LongProperty;
import com.talanlabs.rsqlbuilder.impls.properties.ShortProperty;
import com.talanlabs.rsqlbuilder.impls.properties.StringProperty;
import com.talanlabs.rsqlbuilder.impls.properties.TemporalProperty;

import java.time.temporal.Temporal;

public abstract class AbstractPropertyField<B> extends AbstractField<B> {

    AbstractPropertyField(RsqlBuilder rsqlBuilder, StringBuilder context) {
        super(rsqlBuilder, context);
    }

    /**
     * String field
     *
     * @param field a name
     */
    public StringProperty<B> string(String field) {
        return new StringProperty<>(field, this);
    }

    /**
     * String field
     *
     * @param field a name
     */
    public BooleanProperty<B> bool(String field) {
        return new BooleanProperty<B>(field, this);
    }

    /**
     * Short field
     *
     * @param field a name
     */
    public ShortProperty<B> shortNum(String field) {
        return new ShortProperty<B>(field, this);
    }

    /**
     * Int field
     *
     * @param field a name
     */
    public IntegerProperty<B> intNum(String field) {
        return new IntegerProperty<B>(field, this);
    }

    /**
     * Float field
     *
     * @param field a name
     */
    public FloatProperty<B> floatNum(String field) {
        return new FloatProperty<B>(field, this);
    }

    /**
     * Double field
     *
     * @param field a name
     */
    public DoubleProperty<B> doubleNum(String field) {
        return new DoubleProperty<B>(field, this);
    }

    /**
     * Long field
     *
     * @param field a name
     */
    public LongProperty<B> longNum(String field) {
        return new LongProperty<B>(field, this);
    }

    /**
     * Enum field
     *
     * @param field a name
     */
    public <E extends Enum<E>> EnumProperty<B, E> enumeration(String field) {
        return new EnumProperty<>(field, this);
    }

    /**
     * Temporal field
     *
     * @param field a name
     */
    public <E extends Temporal> TemporalProperty<B, E> temporal(String field) {
        return new TemporalProperty<>(field, this);
    }
}
