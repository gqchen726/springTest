package tk.tianyuge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.tianyuge.bean.test.Test;

import java.util.List;

/**
 * description
 *
 * @author guoqing.chen01@hand-china.com 2022/09/14 13:39
 */
@Mapper
public interface TestMapper {

    List<String> test(String name);
    List<String> test1(String name);
    List<String> test3(String name);
    void batchInsertTest(@Param("list") List<Test> list);
}
