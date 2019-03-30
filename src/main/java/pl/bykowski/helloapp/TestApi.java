package pl.bykowski.helloapp;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {

    @GetMapping("/hellook")
    public String sayHello(@RequestParam(defaultValue = "Guest",
            required = false) String name) {
        return "Hello " + name;
    }

    @PostMapping("/exampleHeader")
    public String requestHeaderExample(@RequestHeader("number") Long number) {
        return "delivered by RequestHeader: " + number;
    }

    @PostMapping("/getExamplePathVariable/{number}")
    public String pathVariableExample(@PathVariable("number") Long number) {
        return "delivered by PathVariable: " + number;
    }
}
