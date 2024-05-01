package restorder.orderproduk.service.RefreshToken;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import restorder.orderproduk.entity.RefreshToken;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.RefreshTokenRepository;
import restorder.orderproduk.service.user.UserServiceImpl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class RefreshTokenServiceImpl implements RefreshTokenService{

    @Value("${jwt.secret.refrEshexpireMs}")
    private Long refreshTokenDurationMs;

    RefreshTokenRepository refreshTokenRepository;

    UserServiceImpl userServiceImpl;

    @Autowired
    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository,UserServiceImpl userServiceImpl) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken createRefreshToken(int userId) {

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userServiceImpl.findById(userId));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {

        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
        }

        return token;
    }

    @Override
    public int deleteByUserId(int userId) {

        User user = userServiceImpl.findById(userId);
        return refreshTokenRepository.deleteByUser(user);
    }



}
