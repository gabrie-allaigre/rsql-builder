package com.talanlabs.rsqlbuilder.impls;

import com.talanlabs.rsqlbuilder.RsqlBuilder;

public class OpennedFieldOpenBuilder<B> extends AbstractPropertyField<CloseableLogicalCloseBuilder<B>> {

    private final B previousBuilder;
    private final StringBuilder context;

    OpennedFieldOpenBuilder(RsqlBuilder rsqlBuilder, B previousBuilder, StringBuilder context) {
        super(rsqlBuilder, context);

        this.previousBuilder = previousBuilder;
        this.context = context;
    }

    @Override
    protected CloseableLogicalCloseBuilder<B> nextBuilder() {
        return new CloseableLogicalCloseBuilder<B>(rsqlBuilder, previousBuilder, context);
    }

    /**
     * Open a new group "("
     */
    public OpennedFieldOpenBuilder<CloseableLogicalCloseBuilder<B>> openGroup() {
        context.append(rsqlBuilder.getOpenGroupSymbol());
        return new OpennedFieldOpenBuilder<>(rsqlBuilder, new CloseableLogicalCloseBuilder<>(rsqlBuilder, previousBuilder, context), context);
    }
}