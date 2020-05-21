package service;

import dao.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import test.Driver;
import util.MD5Util;
import util.MybatisUtils;
import util.Validate;
import view.ChangePasswordView;
import view.LoginView;
import vo.User;


public class UserService {

    public static User user1;
    private SqlSession sqlSession = null;
    private IUserDAO userDAO = null;
    public static String truePassword;
    public  boolean checkLogin(User user) throws Exception{   //检查登录函数
        try {
            this.sqlSession = MybatisUtils.getSqlSession();
            this.userDAO = sqlSession.getMapper(IUserDAO.class);
            if (userDAO.doSelect(user).size()==1) {
                user1 = userDAO.doSelect(user).get(0);
                return LoginView.loginSuccess();
            } else {
                Driver.loginCount++;
                if (Driver.loginCount == 3) {
                    return LoginView.loginFail();
                }
                return LoginView.loginTry();
            }
        }
        catch (SqlSessionException e){
            e.printStackTrace();
        }
      return true;
    }

    public boolean changePassword(String password) throws Exception {    //修改密码函数
        this.sqlSession = MybatisUtils.getSqlSession();
        this.userDAO = sqlSession.getMapper(IUserDAO.class);
        if (!MD5Util.md5(password).equals(user1.getPassword())) {
           return ChangePasswordView.oldPasswordWrong();
        }
       while(!settingPassword(ChangePasswordView.inputNewPassword()));
        user1.setPassword(MD5Util.md5(truePassword));
        if (userDAO.doUpdate(user1)==1) {
            sqlSession.commit();
            return ChangePasswordView.changePasswordSuccess();
        }
        return false;
    }
    public boolean settingPassword(String newPass){   //设置新密码函数
        String verifyPass=null;
        if (!Validate.verifyPassword(newPass)){

            return ChangePasswordView.passwordPatternWrong();
        }
        else{
            verifyPass=ChangePasswordView.inputVerifyPassword();
            if (!verifyPass.equals(newPass)){
                return ChangePasswordView.differentPassword();
            }
            else{
                truePassword=newPass;
                return true;
            }
        }
    }
}
