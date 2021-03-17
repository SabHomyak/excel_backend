package excel.online.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Test {
    @GetMapping("sign")
    public ResponseEntity<HttpStatus> surok() {
        System.out.println("sign");
        return new ResponseEntity<>(HttpStatus.OK);
    }
//
//    @PostMapping("wow")
//    public ResponseEntity<HttpStatus> surosk() {
//        System.out.println("wow");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
