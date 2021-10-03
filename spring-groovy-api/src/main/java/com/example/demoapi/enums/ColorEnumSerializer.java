package com.example.demoapi.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @Author mubi
 * @Date 2021/6/3 22:46
 */
public class ColorEnumSerializer extends StdSerializer {

    public ColorEnumSerializer() {
        super(ColorEnum.class);
    }

    public ColorEnumSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Object o, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        ColorEnum c = (ColorEnum) o;
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeNumber(c.getCode());
        generator.writeFieldName("name");
        generator.writeString(c.getName());
        generator.writeEndObject();
    }
}
