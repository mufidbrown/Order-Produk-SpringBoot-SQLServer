package restorder.orderproduk.service.RefreshToken;

import restorder.orderproduk.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    public Optional<RefreshToken> findByToken(String token);
    public RefreshToken createRefreshToken(long userId);
    public RefreshToken verifyExpiration(RefreshToken token);
    public long deleteByUserId(long userId);

}
