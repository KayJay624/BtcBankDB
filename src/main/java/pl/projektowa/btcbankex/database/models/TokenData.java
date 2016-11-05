package pl.projektowa.btcbankex.database.models;

/**
 * Created by Kamil on 2016-11-01.
 */
public class TokenData {
    private String userId;
    private String token;
    private String generationDate;

    public TokenData(String userId, String token, String generationDate) {
        this.userId = userId;
        this.token = token;
        this.generationDate = generationDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }
}
