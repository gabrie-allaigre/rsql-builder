package com.talanlabs.rsqlbuilder.impls;

import com.talanlabs.rsqlbuilder.RsqlBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractField<B> {

    protected final RsqlBuilder rsqlBuilder;
    protected final StringBuilder context;

    AbstractField(RsqlBuilder rsqlBuilder, StringBuilder context) {
        super();

        this.rsqlBuilder = rsqlBuilder;
        this.context = context;
    }

    /**
     * @return next builder
     */
    protected abstract B nextBuilder();

    /**
     * Custom operation
     *
     * @param field     a name
     * @param operation operation
     * @param value     value of operation
     */
    public B is(String field, String operation, String value) {
        context.append(field).append(operation).append(value);
        return nextBuilder();
    }

    /**
     * Equal to, use ==
     *
     * @param field name
     * @param value value of operation
     */
    public B eq(String field, String value) {
        context.append(field).append(Operator.Equal.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * Not Equal to, use !=
     *
     * @param field name
     * @param value value of operation
     */
    public B neq(String field, String value) {
        context.append(field).append(Operator.NotEqual.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * Less, use ==lt==
     *
     * @param field name
     * @param value value of operation
     */
    public B lt(String field, String value) {
        context.append(field).append(Operator.Less.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * Less or equals, use ==le==
     *
     * @param field name
     * @param value value of operation
     */
    public B lte(String field, String value) {
        context.append(field).append(Operator.LessEqual.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * Greater, use ==gt==
     *
     * @param field name
     * @param value value of operation
     */
    public B gt(String field, String value) {
        context.append(field).append(Operator.Greater.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * Greater or equal, use ==ge==
     *
     * @param field name
     * @param value value of operation
     */
    public B gte(String field, String value) {
        context.append(field).append(Operator.GreaterEqual.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * In, use ==in==
     *
     * @param field name
     * @param value value of operation
     */
    public B in(String field, String value) {
        context.append(field).append(Operator.In.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * Not in, use ==out==
     *
     * @param field name
     * @param value value of operation
     */
    public B nin(String field, String value) {
        context.append(field).append(Operator.NotIn.getSymbol()).append(value);
        return nextBuilder();
    }

    /**
     * And logical
     *
     * @param l1 query not null
     * @param l2 query not null
     * @param ls others query
     */
    public B and(LogicalQueryBuilder l1, LogicalQueryBuilder l2, LogicalQueryBuilder... ls) {
        List<LogicalQueryBuilder> logicals = new ArrayList<>();
        logicals.addAll(Arrays.asList(l1, l2));
        logicals.addAll(Arrays.asList(ls));
        return and(logicals);
    }

    /**
     * And logical
     *
     * @param ls list of query
     */
    public B and(Collection<LogicalQueryBuilder> ls) {
        return condition(rsqlBuilder.getAndSymbol(), ls);
    }

    /**
     * Or logical
     *
     * @param l1 query not null
     * @param l2 query not null
     * @param ls others query
     */
    public B or(LogicalQueryBuilder l1, LogicalQueryBuilder l2, LogicalQueryBuilder... ls) {
        List<LogicalQueryBuilder> logicals = new ArrayList<>();
        logicals.addAll(Arrays.asList(l1, l2));
        logicals.addAll(Arrays.asList(ls));
        return or(logicals);
    }

    /**
     * Or logical
     *
     * @param ls list of query
     */
    public B or(Collection<LogicalQueryBuilder> ls) {
        return condition(rsqlBuilder.getOrSymbol(), ls);
    }

    private B condition(String symbol, Collection<LogicalQueryBuilder> ls) {
        context.append(ls.stream().map(l -> rsqlBuilder.getOpenGroupSymbol() + l.query() + rsqlBuilder.getCloseGroupSymbol())
                .collect(Collectors.joining(symbol, rsqlBuilder.getOpenGroupSymbol(), rsqlBuilder.getCloseGroupSymbol())));
        return nextBuilder();
    }
}