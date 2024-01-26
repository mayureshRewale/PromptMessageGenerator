package va.pmg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class PMGTestController {

    @GetMapping("/get-test")
    public ResponseEntity<?> getTest(){
        return ResponseEntity.ok("TEST DD");
    }

}
