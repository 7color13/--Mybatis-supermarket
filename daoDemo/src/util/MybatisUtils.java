package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class MybatisUtils {
    private SqlSession sqlSession ;
    public static SqlSession getSqlSession() throws Exception{
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
    public void close(){
        if (sqlSession!=null){
            try {
                sqlSession.close();
            } catch (SqlSessionException e) {
                e.printStackTrace();
            }
        }
    }
}
