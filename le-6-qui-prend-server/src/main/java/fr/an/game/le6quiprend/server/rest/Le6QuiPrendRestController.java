package fr.an.game.le6quiprend.server.rest;

import fr.an.game.le6quiprend.common.restapi.dto.TestEchoRequestDTO;
import fr.an.game.le6quiprend.common.restapi.dto.TestEchoResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for game server
 *
 * for swagger, open http://localhost:8080/swagger-ui/index.html
 */
@RestController
@RequestMapping(path="/api/le-6-qui-prend")
@Slf4j
public class Le6QuiPrendRestController {

    private static final String BASEPATH = "/api/le-6-qui-prend";


    /**
     * to check server is running..
     * curl http://localhost:8080/api/le-6-qui-prend/health-check
     */
    @GetMapping("/health-check")
    public void healthCheck() {
        log.info("handle http GET " + BASEPATH + "/health-check");
        // do nothing
    }

    /**
     * to check you can send-request/receive-response
     */
    @PutMapping("/test-echo")
    public TestEchoResponseDTO testEcho(@RequestBody TestEchoRequestDTO req) {
        log.info("handle http PUT " + BASEPATH + "/test-echo");
        TestEchoResponseDTO res = new TestEchoResponseDTO();
        res.fieldInt = req.fieldInt;
        res.fieldString = req.fieldString + " (from server)";
        return res;
    }
}
