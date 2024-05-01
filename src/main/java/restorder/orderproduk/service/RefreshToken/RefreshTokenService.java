package restorder.orderproduk.service.RefreshToken;

import restorder.orderproduk.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    public Optional<RefreshToken> findByToken(String token);
    public RefreshToken createRefreshToken(int userId);
    public RefreshToken verifyExpiration(RefreshToken token);
    public int deleteByUserId(int userId);

}
