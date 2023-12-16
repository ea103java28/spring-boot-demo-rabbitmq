package com.tony.topics;

import com.tony.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {

    @Autowired
    private TopicsProducer topicsProducer;

    @RequestMapping("/topics/send")
    public String send() {
        topicsProducer.send(new Student(1, "xxx.John.aaa"));
        topicsProducer.send(new Student(2, "vvv.Amy.cccc"));
        topicsProducer.send(new Student(3, "eeeeee.Bob.ssssss"));
        topicsProducer.send(new Student(4, "ssss.xxx.John.aaa.zzzzz"));
        topicsProducer.send(new Student(5, "qqqq.wwwwwww.ddddd.vvv.Amy.cccc.xxxxxx"));
        topicsProducer.send(new Student(6, "xxxxxxxx.cdddd.eeeeee.Bob.dddddd.ssss.rrrr.ssssss"));
        return "success";
    }
}