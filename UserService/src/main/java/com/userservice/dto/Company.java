
package com.userservice.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import lombok.Data;

@Data
public class Company {

    public String name;
    public String catchPhrase;
    public String bs;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
