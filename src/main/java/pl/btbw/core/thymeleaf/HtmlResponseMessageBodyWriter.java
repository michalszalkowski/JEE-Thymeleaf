package pl.btbw.core.thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Provider
@Produces(MediaType.TEXT_HTML)
public class HtmlResponseMessageBodyWriter implements MessageBodyWriter<HtmlResponse> {

    private static TemplateEngine templateEngine;

    static {
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());
    }

    @Override
    public void writeTo(HtmlResponse response, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {

        Context context = new Context();
        response.model.forEach((k, v) -> context.setVariable(k, v));
        Writer writer = new OutputStreamWriter(entityStream);
        templateEngine.process(response.templateName, context, writer);
        writer.flush();
    }

    @Override
    public long getSize(HtmlResponse arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
        return -1;
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return HtmlResponse.class.isAssignableFrom(type);
    }

}
