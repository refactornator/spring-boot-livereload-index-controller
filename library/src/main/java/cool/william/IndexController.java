package cool.william;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
public class IndexController {

    @Autowired
    private TemplateEngine templateEngine;

    @Value("#{systemProperties['java.class.path']}")
    private String javaClassPath;

    @Value("${spring.devtools.livereload.enabled:true}")
    private boolean livereloadEnabled;

    @Value("${spring.devtools.livereload.port:35729}")
    private String livereloadPort;

    @ResponseBody
    @RequestMapping("/")
    public String getIndex() {
        Context context = new Context();
        String html = templateEngine.process("index", context);

        boolean devtoolsLoaded = javaClassPath.contains("spring-boot-devtools");
        if (devtoolsLoaded && livereloadEnabled) {
            html = addLiveReload(html);
        }
        return html;
    }

    private String addLiveReload(String html) {
        html = html.replace("</body>", "<script src='/webjars/livereload-js/3.0.0/dist/livereload.js?port=" + livereloadPort + "'></script>\n</body>");
        return html;
    }
}

