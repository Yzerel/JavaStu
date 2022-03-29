package com.godc.MybatisTest.Mapper;

import com.godc.MybatisTest.Bean.MyBoy;
import com.godc.MybatisTest.Bean.Person;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MyPerson {
    public Person getPersonID(Integer id);
    public List<Person> getMuchPerson(Integer id);

    public Map<String, Object> getMapPerson(Integer id);

    @MapKey("name")
    public Map<String, Person> getMapPersonKV(Integer id);


    public List<Person> getRangePerson(Integer startid, Integer stopid);
    public List<Person> getRangePerson2(@Param("startid") Integer startid,@Param("stopid") Integer stopid);

    // 在同一接口下，可以实现多个 javabean对象
    public MyBoy getMyBoy(Integer id);
}
