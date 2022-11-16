package com.sunknowledge.dme.rcm.repository.usps;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class UrbanizationMasterSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("urbanization_id", table, columnPrefix + "_urbanization_id"));
        columns.add(Column.aliased("urbanization", table, columnPrefix + "_urbanization"));
        columns.add(Column.aliased("abbreviation", table, columnPrefix + "_abbreviation"));

        return columns;
    }
}
