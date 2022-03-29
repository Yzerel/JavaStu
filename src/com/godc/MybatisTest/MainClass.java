package com.godc.MybatisTest;
import com.godc.MybatisTest.Bean.MyBoy;
import com.godc.MybatisTest.Bean.Person;
import com.godc.MybatisTest.Mapper.MyPerson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static SqlSessionFactory getsqlSessionFactory(){

        String resource = "com/godc/MybatisTest/conf/mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return sqlSessionFactory;
    }
    @Test
    public void test02() throws IOException{
        SqlSessionFactory sqlSessionFactory = getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MyPerson mapper = sqlSession.getMapper(MyPerson.class);
        MyBoy myBoy = mapper.getMyBoy(1);
        System.out.println(myBoy); // 在同一接口下，可以实现多个 javabean对象
    }



    @Test
    public void test01() throws IOException{

        SqlSessionFactory sqlSessionFactory = getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MyPerson mapper = sqlSession.getMapper(MyPerson.class);
        Person person = mapper.getPersonID(1);
        System.out.println(person);
        System.out.println("*********** 返回一个列表，多个人 **********");
        List<Person> muchPerson = mapper.getMuchPerson(1);
        for (Person muchPerson1 : muchPerson) {
            System.out.println(muchPerson1);
        }
        System.out.println("*********** 返回一个map **********");
        Map<String, Object> mapPerson = mapper.getMapPerson(1);
        System.out.println(mapPerson);

        System.out.println("*********** 返回以name为hash 的key 的map mapKV **********");
        Map<String, Person> mapPersonKV = mapper.getMapPersonKV(3);
        System.out.println(mapPersonKV); // 本应有两条 name= aaa 的数据的

        System.out.println("范围查询");
        List<Person> rangePerson = mapper.getRangePerson2(1, 3);
        for (Person rangePerson1 : rangePerson) {
            System.out.println(rangePerson1);
        }

        sqlSession.close();
    }
}
