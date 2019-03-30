package pl.bykowski.helloapp;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Hello {

    private List<User> users;

    public Hello() {
        this.users = new ArrayList<>();
    }

    @GetMapping("/api")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/api")
    public void addUser(@RequestBody User user) {
        users.add(user);
    }


    @DeleteMapping("/api")
    public boolean removeUser(@RequestParam long id) {
        Optional<User> first = users.stream()
                .filter(x -> id == x.getId()).findFirst();
        if (first.isPresent()) {
            return users.remove(first.get());
        }
        return false;
    }


}
