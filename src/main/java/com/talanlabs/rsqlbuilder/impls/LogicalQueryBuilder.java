package com.talanlabs.rsqlbuilder.impls;

import com.talanlabs.rsqlbuilder.RsqlBuilder;

public class LogicalQueryBuilder extends AbstractLogical<FieldOpenBuilder> {

    LogicalQueryBuilder(RsqlBuilder rsqlBuilder, StringBuilder context) {
        super(rsqlBuilder, context);
    }

    @Override
    protected FieldOpenBuilder nextBuilder() {
        return new FieldOpenBuilder(rsqlBuilder, context);
    }

    /**
     * @return rsql query
     */
    public String query() {
        return context.toString();
    }
}