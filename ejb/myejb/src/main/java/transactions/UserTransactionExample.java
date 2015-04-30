package transactions;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class UserTransactionExample {
	
	@Resource
	private UserTransaction tx;
	
	public void someMethod() throws NamingException, NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		Context jndiCtx = new InitialContext();
		UserTransaction utx = (UserTransaction) jndiCtx.lookup("java:comp/UserTransaction");
		utx.begin();
		utx.commit();
	}
	
	public void someMethod2() throws NamingException{


		try {
			tx.begin();
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
