package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.usps.USPSStateMaster;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link USPSStateMaster}, with proper type conversions.
 */
@Service
public class USPSStateMasterRowMapper implements BiFunction<Row, String, USPSStateMaster> {

    private final ColumnConverter converter;

    public USPSStateMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link USPSStateMaster} stored in the database.
     */
    @Override
    public USPSStateMaster apply(Row row, String prefix) {
        USPSStateMaster entity = new USPSStateMaster();
        entity.setStateId(converter.fromRow(row, prefix + "_state_id", Long.class));
        entity.setStateName(converter.fromRow(row, prefix + "_state_name", String.class));
        entity.setPostalAbbriviation(converter.fromRow(row, prefix + "_postal_abbriviation", String.class));
        entity.setFipsCode(converter.fromRow(row, prefix + "_fips_code", String.class));
        return entity;
    }
}
