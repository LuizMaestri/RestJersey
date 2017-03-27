package auth;

import auth.domain.Token;
import dao.EntityDao;

/**
 * @author luiz.maestri
 * @since 27/03/17
 */
public class TokenDao extends EntityDao<Token> {


    @Override
    protected Class<Token> getEntityClass() {
        return Token.class;
    }
}
