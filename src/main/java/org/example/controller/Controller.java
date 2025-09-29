package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {


    @GetMapping("/adjust-stitches")
    public Map<String, Object> adjustStitches(
            @RequestParam double patternGauge,
            @RequestParam int patternStitches,
            @RequestParam double myGauge) {

        Map<String, Object> result = new HashMap<>();

        // Beräkna antal maskor för egen stickfasthet
        int adjustedStitches = (int) Math.round(patternStitches * myGauge / patternGauge);

        result.put("adjustedStitches", adjustedStitches);
        return result;
    }
}
