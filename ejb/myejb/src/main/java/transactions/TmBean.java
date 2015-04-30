package transactions;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class TmBean {
	final static Logger logger = LoggerFactory.getLogger(TmBean.class);
	
	@Resource(mappedName = "java:/TransactionManager")
	// mappedName is vendor-specific, and in this case points to an
	// address in JNDI
	private TransactionManager txManager;

	@PostConstruct
	public void initialize() throws Exception{
		final Transaction tx = txManager.getTransaction();
		boolean startOurOwnTx = tx == null;
		if (startOurOwnTx){
			txManager.begin();
		}
		
		try{
			logger.info("inside the transaction");
		}
		catch(final Throwable t){
			if (startOurOwnTx){
				txManager.setRollbackOnly();
			}
		}
		finally{
			txManager.commit();
		}
		
	}
}
