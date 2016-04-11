package pl.btbw.core.thymeleaf;

import java.util.HashMap;
import java.util.Map;

public class HtmlResponse {

    public String templateName;
    public Map<String, Object> model = new HashMap<>();

    public HtmlResponse(String templateName) {
        this.templateName = templateName;
    }

    public HtmlResponse add(String modelName, Object model) {
        this.model.put(modelName, model);
        return this;
    }
}
