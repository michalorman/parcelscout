package pl.michalorman.springframework.web.servlet.view.yaml;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

/**
 * Spring-MVC {@link View} that renders YAML content by serializing the model for the current request using <a
 * href="http://code.google.com/p/snakeyaml/">SnakeYAML</a> library.
 * 
 * @author Michal Orman
 */
public class SnakeYAMLView extends AbstractView {

    /** MIME type accepted by this view */
    public static final String DEFAULT_CONTENT_TYPE = "application/x-yaml";

    public SnakeYAMLView() {
        setContentType(DEFAULT_CONTENT_TYPE);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Map<String, Object> filteredModel = filterModel(model);
        StringBuilder builder = new StringBuilder();
        Yaml yaml = new Yaml();
        yaml.setBeanAccess(BeanAccess.FIELD);

        for (Map.Entry<String, Object> entry : filteredModel.entrySet()) {
            builder.append(String.format("%s\n", yaml.dump(entry.getValue())));
        }

        response.getOutputStream().print(builder.toString());
    }

    /**
     * Filters out undesired attributes from the model.
     * 
     * @param object
     * @return
     */
    private Map<String, Object> filterModel(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();

            if (!(value instanceof BindingResult) && !(value instanceof BeanPropertyBindingResult)) {
                result.put(key, value);
            }
        }
        return result;
    }

    @Override
    protected void prepareResponse(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(getContentType());
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
        response.addDateHeader("Expires", 1L);
    }

}
