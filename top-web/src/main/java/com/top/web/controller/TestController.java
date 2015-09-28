package com.top.web.controller;

import com.top.core.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/15
 * Time: 14:56
 * <p>
 * TODO
 */
@Controller
public class TestController extends AbstractController {

    @RequestMapping("test")
    @ResponseBody
    public String test(@RequestParam Integer param1, @RequestParam Integer p2,
                       @RequestParam String p3, @RequestParam String p4) {
            integralRecordService.add(2,11,"1111","33333");
        return "111";
    }
}
