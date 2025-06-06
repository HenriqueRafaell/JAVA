package br.com.fiap.guardiao.verde.utils;

import br.com.fiap.guardiao.verde.domain.enums.PrioridadeAlerta;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PrioridadeAlertaConverter implements AttributeConverter<PrioridadeAlerta, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PrioridadeAlerta atributo) {
        return atributo == null ? null : atributo.getNivel();
    }

    @Override
    public PrioridadeAlerta convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        for (PrioridadeAlerta p : PrioridadeAlerta.values()) {
            if (p.getNivel() == dbData) return p;
        }
        throw new IllegalArgumentException("Valor inválido para PrioridadeAlerta: " + dbData);
    }
}