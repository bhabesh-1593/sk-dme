package com.sunknowledge.dme.rcm.repository.usps;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class USPSStateMasterSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("state_id", table, columnPrefix + "_state_id"));
        columns.add(Column.aliased("state_name", table, columnPrefix + "_state_name"));
        columns.add(Column.aliased("postal_abbriviation", table, columnPrefix + "_postal_abbriviation"));
        columns.add(Column.aliased("fips_code", table, columnPrefix + "_fips_code"));

        return columns;
    }
}
