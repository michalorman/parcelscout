package pl.michalorman.springframework.web.servlet.view.json;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.Map;

/**
 * Spring-MVC {@link org.springframework.web.servlet.View} that renders JSON content by serializing the model for the current request using <a
 * href="http://jackson.codehaus.org/">Jackson's</a> {@link org.codehaus.jackson.map.ObjectMapper}.
 *
 * This class basically extends {@link org.springframework.web.servlet.view.json.MappingJacksonJsonView} class
 * to return single value instead of {@link java.util.Map} (for JSON transformation) if model consist of exactly
 * one element.
 */
public class SingleValueMappingJacksonJsonView extends MappingJacksonJsonView {

    /** Value related to this key in model will be serialized */
    private String valueKey;

    /**
     * Returns single object if model consist of exactly one element, otherwise returns {@link java.util.Map}.
     *
     * @param model
     * @return
     */
    @Override
    protected Object filterModel(Map<String, Object> model) {
        Object result = super.filterModel(model);

        if (result instanceof Map) {
            Map map = (Map) result;
            if (map.size() == 1) {
                result = map.values().toArray()[0];
            }
        }

        return result;
    }
}
