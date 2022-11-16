package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.usps.UrbanizationMaster;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link UrbanizationMaster}, with proper type conversions.
 */
@Service
public class UrbanizationMasterRowMapper implements BiFunction<Row, String, UrbanizationMaster> {

    private final ColumnConverter converter;

    public UrbanizationMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link UrbanizationMaster} stored in the database.
     */
    @Override
    public UrbanizationMaster apply(Row row, String prefix) {
        UrbanizationMaster entity = new UrbanizationMaster();
        entity.setUrbanizationId(converter.fromRow(row, prefix + "_urbanization_id", Long.class));
        entity.setUrbanization(converter.fromRow(row, prefix + "_urbanization", String.class));
        entity.setAbbreviation(converter.fromRow(row, prefix + "_abbreviation", String.class));
        return entity;
    }
}
