package fr.an.game.le6quiprend.server.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for game server
 *
 * for swagger, open http://localhost:8080/swagger-ui/index.html
 */
@RestController
@RequestMapping(path="/api/le-6-qui-prend")
public class Le6QuiPrendRestController {

    /**
     * to check server is running..
     * curl http://localhost:8080/api/le-6-qui-prend/health-check
     */
    @GetMapping("/health-check")
    public void healthCheck() {
        // do nothing
    }

}
