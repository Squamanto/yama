package de.kripas.yama.controller;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@RestController(value = "/")
public class FrontendController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "forward:/";
    }

    @GetMapping(value = "/log-output")
    public String logAuth(HttpServletRequest request) {
        StringBuilder output = new StringBuilder("Auth Type: " + request.getAuthType() + "\n");
        output.append("Auth Header: ").append(request.getHeader("Authorization")).append("\n");
        for (int i = 0; i < request.getCookies().length; i++) {
            output.append("Cookie: ").append(request.getCookies()[i].toString()).append("\n");
        }
        for (Iterator<String> it = request.getHeaderNames().asIterator(); it.hasNext(); ) {
            String name = it.next();
            String headerValue = request.getHeader(name);
            output.append("Header: ").append(name).append(" ").append(headerValue).append("\n");
        }

        logger.info(output.toString());

        return output.toString();
    }
}
