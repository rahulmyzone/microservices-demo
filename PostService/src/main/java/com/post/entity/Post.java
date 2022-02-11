
package com.post.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    public Integer userId;
    public Integer id;
    public String title;
    public String body;
    public List<Comment> comments;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
