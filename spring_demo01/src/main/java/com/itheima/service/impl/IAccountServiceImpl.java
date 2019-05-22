package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.IAccountDaoImpl;
import com.itheima.service.IAccountService;

public class IAccountServiceImpl implements IAccountService {
      private IAccountDao accountDao ;

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount() {
       accountDao.saveAccount();
    }
}
