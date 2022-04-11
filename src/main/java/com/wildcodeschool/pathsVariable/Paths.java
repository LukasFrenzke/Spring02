package com.wildcodeschool.pathsVariable;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class Paths {
    @RequestMapping("/doctor/{incarnationNumber}")
    @ResponseBody
	public Map<String, String> paths(@PathVariable int incarnationNumber) {
        if (incarnationNumber >=9 && incarnationNumber <= 13){
            if (incarnationNumber == 9){
                Map<String, String> map = new HashMap<String, String>();
                map.put("number", "9");
                map.put("name", "Christopher Eccleston");
                return map;
            }
            else if (incarnationNumber == 10){
                Map<String, String> map = new HashMap<String, String>();
                map.put("number", "10");
                map.put("name", "David Tennant");
                return map;
            }
            else if (incarnationNumber == 11){
                Map<String, String> map = new HashMap<String, String>();
                map.put("number", "11");
                map.put("name", "Matt Smith");
                return map;
            }
            else if (incarnationNumber == 12){
                Map<String, String> map = new HashMap<String, String>();
                map.put("number", "12");
                map.put("name", "Peter Capaldi");
                return map;
            }
            else {
                Map<String, String> map = new HashMap<String, String>();
                map.put("number", "13");
                map.put("name", "Jodie Whittaker");
                return map;
            }
        }else if (incarnationNumber >= 1 && incarnationNumber <= 8){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        }else {
            String reason = "Impossible to retrieve the incarnation " + incarnationNumber;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,reason);
        }

    }
}
