package pl.projektowa.btcbankex.database.actions;

import pl.projektowa.btcbankex.model.User;

/**
 * Created by Kamil Jurek on 2016-11-01.
 */
public interface UserActions {
    boolean isUserInDatabase(int userId);
    boolean isUserInDatabase(String login, String password);

    boolean addUserToDatabase(User user);

    User getUserFromDatabase(int userId) throws Exception;
    User getUserFromDatabase(String login, String password) throws Exception;
}
