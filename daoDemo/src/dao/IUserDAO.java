package dao;

import vo.User;

import java.util.List;

public interface IUserDAO {   //用户接口
    public int doUpdate(User user) throws Exception;
    public List<User> doSelect(User user) throws Exception;
    public boolean doInsert(User user) throws Exception;
    public boolean doDelete(User user) throws Exception;
}
