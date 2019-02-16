package com.mvc.DTO;
import com.mvc.deme.Account;
import com.mvc.deme.User;
/**
 * DTO数据传输层（要求：只能提供自定义对象，不能放包装类和基本数据类型）
 * DTO与VO的区别：
 * VO：既可以放属性（也就是包装类和基本数据类型），也可以放对象
 */
public class BaseDTO {
    private User user;
    private Account account;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "user=" + user +
                ", account=" + account +
                '}';
    }
}
