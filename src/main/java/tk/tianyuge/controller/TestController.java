package tk.tianyuge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.tianyuge.bean.test.Test;
import tk.tianyuge.mapper.TestMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author guoqing.chen01@hand-china.com 2022/09/14 13:42
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestMapper testMapper;
    private static final Logger logger =
            LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test1")
    @ResponseBody
    public List<String> test1(@RequestParam String name){
        if (name.contains("\\")) {
            name = name.replaceAll("\\\\", "\\\\\\\\");
        }
        System.out.println(name);
        List<String> result = testMapper.test(name);
        result.forEach(System.out::println);
        return result;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public List<String> test2(@RequestParam String name){
        if (name.contains("\\")) {
            name = name.replaceAll("\\\\", "\\\\\\\\");
        }

        List<String> result = testMapper.test1(name);
        result.forEach(System.out::println);
        return result;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public List<String> test3(@RequestParam String name){
        if (name.contains("\\")) {
            name = name.replaceAll("\\\\", "\\\\\\\\");
        }

        List<String> result = testMapper.test3(name);
        result.forEach(System.out::println);
        return result;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test4(@RequestParam List<String> name){
        return String.join("", name);
    }

    @RequestMapping("/test5")
    @ResponseBody
    public void test5(){
        int i = 0;
        List<Test> testList = new ArrayList<>();
        Test test;
        for (int j = 0; j < 1000; j++) {
            test = new Test();
            test.setId(Integer.toUnsignedLong(i));
            test.setName(Integer.toString(i));
            testList.add(test);
            i++;
        }
        long start = System.currentTimeMillis();
        logger.debug(new Date().toString());
        testMapper.batchInsertTest(testList);
        long end = System.currentTimeMillis();
        logger.debug(new Date().toString());
        logger.debug((end-start) + "ms");

    }
}
