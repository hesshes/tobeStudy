package springbook.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserLevelUpgradePolicy implements UserLevelUpgrade {

    @Autowired
    UserDao userDao;

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMENT_FOR_GOLD = 30;

    public boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
        case BASIC:
            return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
        case SILVER:
            return (user.getRecommend() >= MIN_RECCOMENT_FOR_GOLD);
        case GOLD:
            return false;
        default:
            throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }

    public void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }

}
