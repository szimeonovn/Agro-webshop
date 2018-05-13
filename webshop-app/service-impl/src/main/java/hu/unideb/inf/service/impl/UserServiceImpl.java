package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entity.UserEntity;
import hu.unideb.inf.persistence.repository.UserRepository;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.User;
import hu.unideb.inf.service.exception.EmailAlreadyUsedException;
import hu.unideb.inf.service.exception.ExceptionDetails;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Implementation of {@link UserService}.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void registerUser(User user) throws EmailAlreadyUsedException{
        Assert.notNull(user, "User can not be null");

        if (userRepository.findByEmail(user.getEmail()) != null) {
            LOGGER.warn("User already exists with this email : {} ", user.getEmail());
            ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                    .key("email")
                    .value(String.format("user already exists with this email : %s", user.getEmail()))
                    .build();
            throw new EmailAlreadyUsedException(String.format("Email=%s already used", user.getEmail()), exceptionDetails);
        }

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userRepository.save(userEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        Assert.notNull(email, "Email can not be null");
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity != null) {
            return modelMapper.map(userEntity, User.class);
        }
        return null;
    }
}

