package com.sunknowledge.dme.rcm.repository.usps;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FootnoteMasterSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("footnotes_id", table, columnPrefix + "_footnotes_id"));
        columns.add(Column.aliased("enumerations", table, columnPrefix + "_enumerations"));
        columns.add(Column.aliased("definition", table, columnPrefix + "_definition"));

        return columns;
    }
}
