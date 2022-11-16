package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.nppes.NpiMaster;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link NpiMaster}, with proper type conversions.
 */
@Service
public class NpiMasterRowMapper implements BiFunction<Row, String, NpiMaster> {

    private final ColumnConverter converter;

    public NpiMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link NpiMaster} stored in the database.
     */
    @Override
    public NpiMaster apply(Row row, String prefix) {
        NpiMaster entity = new NpiMaster();
        entity.setNpiId(converter.fromRow(row, prefix + "_npi_id", Long.class));
        entity.setNpiNumber(converter.fromRow(row, prefix + "_npi_number", String.class));
        entity.setEnumerationType(converter.fromRow(row, prefix + "_enumeration_type", String.class));
        entity.setNpiName(converter.fromRow(row, prefix + "_npi_name", String.class));
        entity.setAddress(converter.fromRow(row, prefix + "_address", String.class));
        entity.setPhone(converter.fromRow(row, prefix + "_phone", String.class));
        return entity;
    }
}
