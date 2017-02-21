package com.talanlabs.rsqlbuilder.impls;

import com.talanlabs.rsqlbuilder.RsqlBuilder;

public abstract class AbstractLogical<B> {

    protected final RsqlBuilder rsqlBuilder;
    protected final StringBuilder context;

    AbstractLogical(RsqlBuilder rsqlBuilder, StringBuilder context) {
        super();

        this.rsqlBuilder = rsqlBuilder;
        this.context = context;
    }

    /**
     * @return next builder
     */
    protected abstract B nextBuilder();

    /**
     * AND operation
     */
    public B and() {
        context.append(rsqlBuilder.getAndSymbol());
        return nextBuilder();
    }

    /**
     * OR operation
     */
    public B or() {
        context.append(rsqlBuilder.getOrSymbol());
        return nextBuilder();
    }
}