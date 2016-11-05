package pl.projektowa.btcbankex.database.actions;

import pl.projektowa.btcbankex.model.TokenData;

/**
 * Created by Kamil Jurek on 2016-11-01.
 */
public interface AuthorizationActions {
    boolean isTokenInDatabase(String token);
    TokenData getTokenData(int userId) throws Exception;
    TokenData getTokenData(String token) throws Exception;
}
