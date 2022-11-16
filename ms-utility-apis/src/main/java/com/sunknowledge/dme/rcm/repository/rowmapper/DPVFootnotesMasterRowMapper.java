package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.usps.DPVFootnotesMaster;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link DPVFootnotesMaster}, with proper type conversions.
 */
@Service
public class DPVFootnotesMasterRowMapper implements BiFunction<Row, String, DPVFootnotesMaster> {

    private final ColumnConverter converter;

    public DPVFootnotesMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link DPVFootnotesMaster} stored in the database.
     */
    @Override
    public DPVFootnotesMaster apply(Row row, String prefix) {
        DPVFootnotesMaster entity = new DPVFootnotesMaster();
        entity.setDpvFootnotesId(converter.fromRow(row, prefix + "_dpv_footnotes_id", Long.class));
        entity.setEnumerations(converter.fromRow(row, prefix + "_enumerations", String.class));
        entity.setDefinition(converter.fromRow(row, prefix + "_definition", String.class));
        return entity;
    }
}
