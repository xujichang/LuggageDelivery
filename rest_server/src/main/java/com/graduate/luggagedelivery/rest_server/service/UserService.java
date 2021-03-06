package com.graduate.luggagedelivery.rest_server.service;

import com.graduate.luggagedelivery.rest_server.base.Status;
import com.graduate.luggagedelivery.rest_server.base.WrapperEntity;
import com.graduate.luggagedelivery.rest_server.dao.TUserMapper;
import com.graduate.luggagedelivery.rest_server.entity.TUser;
import com.graduate.luggagedelivery.rest_server.entity.TUserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户相关接口
 */
@Service
public class UserService implements IUserService {
    @Resource
    private TUserMapper userMapper;

    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public WrapperEntity<TUser> userLogin(String account, String password) {
        TUserExample example = new TUserExample();
        example.createCriteria().andUnameEqualTo(account).andUserpasswordEqualTo(password);
        List<TUser> users = userMapper.selectByExample(example);
        TUser user = null;
        WrapperEntity<TUser> wrapperEntity = new WrapperEntity<>();
        if (null != users && users.size() > 0) {
            user = users.get(0);
            wrapperEntity.setStatus(Status.SUCCESS);
        } else {
            wrapperEntity.setStatus(Status.LOGIN_FAILED);
        }
        wrapperEntity.setData(user);
        return wrapperEntity;
    }

    @Override
    public WrapperEntity<TUser> updateUserInfo(TUser user) {
        int result = userMapper.updateByPrimaryKey(user);
        if (result > 0) {
            return new WrapperEntity<>(userMapper.selectByPrimaryKey(user.getUserid()));
        }
        return new WrapperEntity<>(Status.UPDATE_FAILED);
    }
}
