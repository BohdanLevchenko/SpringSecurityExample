package fast.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/private")
public class PrivateResource {

    @GetMapping
    public String get(Principal principal) {
        return "private (" + principal.getName() + ")";
    }
}
