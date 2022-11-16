package com.sunknowledge.dme.rcm.repository.nppes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class NpiMasterSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("npi_id", table, columnPrefix + "_npi_id"));
        columns.add(Column.aliased("npi_number", table, columnPrefix + "_npi_number"));
        columns.add(Column.aliased("enumeration_type", table, columnPrefix + "_enumeration_type"));
        columns.add(Column.aliased("npi_name", table, columnPrefix + "_npi_name"));
        columns.add(Column.aliased("address", table, columnPrefix + "_address"));
        columns.add(Column.aliased("phone", table, columnPrefix + "_phone"));

        return columns;
    }
}
