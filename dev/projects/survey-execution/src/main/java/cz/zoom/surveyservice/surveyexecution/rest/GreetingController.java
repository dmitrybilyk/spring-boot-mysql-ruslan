package cz.zoom.surveyservice.surveyexecution.rest;

import cz.zoom.surveyservice.surveyexecution.rest.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dik81 on 28.11.18.
 */
@RestController
public class GreetingController {
    private static final String template = "Hello,%s and %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name1", defaultValue="World") String name1,
                             @RequestParam(value="name2", defaultValue="World") String name2) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name1, name2));
    }
}
