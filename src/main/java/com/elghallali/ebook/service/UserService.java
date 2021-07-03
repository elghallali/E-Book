package com.elghallali.ebook.service;

import java.util.Set;

import com.elghallali.ebook.model.User;
import com.elghallali.ebook.model.UserBilling;
import com.elghallali.ebook.model.UserPayment;
import com.elghallali.ebook.model.UserShipping;
import com.elghallali.ebook.model.security.PasswordResetToken;
import com.elghallali.ebook.model.security.UserRole;

public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    Boolean existByUsername(String username);

    Boolean existByEmail(String email);

    User findById(Long id);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);

    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void updateUserShipping(UserShipping userShipping, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);

    void setUserDefaultShipping(Long userShippingId, User user);

}
