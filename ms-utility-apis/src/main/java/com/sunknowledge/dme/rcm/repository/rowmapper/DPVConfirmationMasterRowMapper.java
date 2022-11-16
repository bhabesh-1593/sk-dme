package com.sunknowledge.dme.rcm.repository.rowmapper;

import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;

/**
 * Converter between {@link Row} to {@link DPVConfirmationMaster}, with proper type conversions.
 */
@Service
public class DPVConfirmationMasterRowMapper implements BiFunction<Row, String, DPVConfirmationMaster> {

    private final ColumnConverter converter;

    public DPVConfirmationMasterRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link DPVConfirmationMaster} stored in the database.
     */
    @Override
    public DPVConfirmationMaster apply(Row row, String prefix) {
        DPVConfirmationMaster entity = new DPVConfirmationMaster();
        entity.setDpvConfirmationId(converter.fromRow(row, prefix + "_dpv_confirmation_id", Long.class));
        entity.setEnumerations(converter.fromRow(row, prefix + "_enumerations", String.class));
        entity.setDefinition(converter.fromRow(row, prefix + "_definition", String.class));
        return entity;
    }
}
