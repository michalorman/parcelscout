package pl.michalorman.springframework.web.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

/**
 * Creates Jackson's {@link org.codehaus.jackson.map.ObjectMapper} that uses JAXB annotations
 * (instead of Jackson's annotations) for object deserialization. 
 *
 * User: Michal Orman
 */
public class JaxbJacksonObjectMapper extends ObjectMapper {

    public JaxbJacksonObjectMapper() {
        super();
        getDeserializationConfig().setAnnotationIntrospector(new JaxbAnnotationIntrospector());
    }
}
