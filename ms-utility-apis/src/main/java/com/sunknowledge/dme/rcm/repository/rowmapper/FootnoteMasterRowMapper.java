package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.usps.FootnoteMaster;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link FootnoteMaster}, with proper type conversions.
 */
@Service
public class FootnoteMasterRowMapper implements BiFunction<Row, String, FootnoteMaster> {

    private final ColumnConverter converter;

    public FootnoteMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FootnoteMaster} stored in the database.
     */
    @Override
    public FootnoteMaster apply(Row row, String prefix) {
        FootnoteMaster entity = new FootnoteMaster();
        entity.setFootnotesId(converter.fromRow(row, prefix + "_footnotes_id", Long.class));
        entity.setEnumerations(converter.fromRow(row, prefix + "_enumerations", String.class));
        entity.setDefinition(converter.fromRow(row, prefix + "_definition", String.class));
        return entity;
    }
}
