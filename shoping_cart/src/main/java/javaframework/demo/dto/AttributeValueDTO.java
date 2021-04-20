package javaframework.demo.dto;

import lombok.Data;
import org.dom4j.Attribute;

@Data
public class AttributeValueDTO extends AbstractDTO<AttributeValueDTO>{
    private String value;
    private Long attributeId;
}
