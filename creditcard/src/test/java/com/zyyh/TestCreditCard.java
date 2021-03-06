package com.zyyh;

import com.zyyh.strategy.PayByCreditCardBySatges;
import com.zyyh.strategy.PayByCreditCardDirect;
import com.zyyh.strategy.PayByPos;
import com.zyyh.strategy.PayByWeChat;
import org.junit.Assert;
import org.junit.Test;


public class TestCreditCard {
    @Test
    public void test_common_user_pos(){
        //新建用户，非VIP
        User user=new User(false);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用pos消费1000
        user.setPayStrategy(new PayByPos(1000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(100,user.getTotalPoint());
    }

    @Test
    public void test_common_user_wechat(){
        //新建用户，非VIP
        User user=new User(false);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用微信消费1000
        user.setPayStrategy(new PayByWeChat(1000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(50,user.getTotalPoint());
    }
    @Test
    public void test_common_user_creditcard_direct_in_100(){
        //新建用户，非VIP
        User user=new User(false);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡快捷消费1000
        user.setPayStrategy(new PayByCreditCardDirect(1000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(150,user.getTotalPoint());
    }
    @Test
    public void test_common_user_creditcard_direct_out_100(){
        //新建用户，非VIP
        User user=new User(false);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡快捷消费1000
        user.setPayStrategy(new PayByCreditCardDirect(3000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(400,user.getTotalPoint());
    }
    @Test
    public void test_common_user_creditcard_by_stages_in_5000(){
        //新建用户，非VIP
        User user=new User(false);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡分期消费1000
        user.setPayStrategy(new PayByCreditCardBySatges(3000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(300,user.getTotalPoint());
    }
    @Test
    public void test_common_user_creditcard_by_stages_out_5000(){
        //新建用户，非VIP
        User user=new User(false);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡分期消费1000
        user.setPayStrategy(new PayByCreditCardBySatges(6000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(700,user.getTotalPoint());
    }
    @Test
    public void test_vip_user_pos(){
        //新建用户，VIP
        User user=new User(true);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用pos消费1000
        user.setPayStrategy(new PayByPos(1000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(150,user.getTotalPoint());
    }
    @Test
    public void test_vip_user_wechat(){
        //新建用户，非VIP
        User user=new User(true);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用微信消费1000
        user.setPayStrategy(new PayByWeChat(1000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(75,user.getTotalPoint());
    }
    @Test
    public void test_vip_user_creditcard_direct_in_100(){
        //新建用户，非VIP
        User user=new User(true);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡快捷消费1000
        user.setPayStrategy(new PayByCreditCardDirect(1000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(200,user.getTotalPoint());
    }
    @Test
    public void test_vip_user_creditcard_direct_out_100(){
        //新建用户，非VIP
        User user=new User(true);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡快捷消费1000
        user.setPayStrategy(new PayByCreditCardDirect(3000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(550,user.getTotalPoint());
    }
    @Test
    public void test_vip_user_creditcard_by_stages_in_5000(){
        //新建用户，VIP
        User user=new User(true);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡分期消费1000
        user.setPayStrategy(new PayByCreditCardBySatges(3000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(450,user.getTotalPoint());
    }
    @Test
    public void test_vip_user_creditcard_by_stages_out_5000(){
        //新建用户，VIP
        User user=new User(true);
        //初始化信用卡系统
        CreditCardSystem system=new CreditCardSystem();
        //用户在系统注册
        system.addUser(user);
        //用户使用信用卡分期消费1000
        user.setPayStrategy(new PayByCreditCardBySatges(6000));
        //计算积分
        user.computePoint();
        Assert.assertEquals(1000,user.getTotalPoint());
    }
}
