package com.arek.jpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arek.jpa.inheritance.Cat;
import com.arek.jpa.inheritance.single.Apple;
import com.arek.jpa.lifecycle.World;

public class JpaTest {
    
    private Logger log = LoggerFactory.getLogger(JpaTest.class);

	private EntityManager em;
	EntityManagerFactory emf;

	public JpaTest() {
		String unitName;
		// unitName ="sample";
		unitName = "fileDatabase";

		emf = Persistence
				.createEntityManagerFactory(unitName);
		em = emf.createEntityManager();

		
		emf.close();
	}

	public void create() {
		Person person = new Person();
		person.setFirstName("Kubuś");
		person.setLastName("Uszatek" + System.currentTimeMillis());
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("color", "green");
		person.setSomeMap(map);
		
		
		Pesel pesel = new Pesel();
		em.persist(pesel);
		person.setPesel(pesel);
		em.merge(person);
		em.flush();
		
		
		person = em.merge(person);
		em.remove(person);
		em.flush();
	}

	public void find() {
		List list = em.createQuery("select p from Person p").getResultList();
		System.out.println("rows: " + list.size());
		for (Object row : list) {
			System.out.println("row: " + row);
		}
	}
	
	public void lock() {
		Person person = new Person();
		person.setFirstName("Kubuś");
		person.setLastName("Uszatek" + System.currentTimeMillis());
		
		em.persist(person);
		em.flush();
		
		
		/*
		 * SELECT FOR UPDATE NOT WORKING!!!!!!!!! (TRY OTHER DATABASE)
		 */
		Query query = em.createQuery("select p from Person p");
		query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
		
		List<Person> list = query.getResultList();
		System.out.println("rows: " + list.size());
		for (Person row : list) {
			System.out.println("row: " + row);
			//em.lock(row, LockModeType.PESSIMISTIC_WRITE);
			if(!row.getFirstName().equals("DFSDf")){
				row.setFirstName("Nowy" + row.getFirstName());
				
							
			}
			System.out.println("id: " + row.getId());
			em.flush();
		}
		/*
		Person p = em.find(Person.class, 1, LockModeType.PESSIMISTIC_READ);
		p.setFirstName("DFSDF");
		*/
		
	}
	
	public void queries(){
		Query q = em.createQuery("select VALUE(m) from Person p join p.someMap m where KEY(m)='ala'");
		q.getResultList();
	}
	

	public void queriesFetch(){
		Person p = new Person();
		p.setFirstName("Arek");
	
		Person child1 = new Person();
		Person child2 = new Person();
		
		p.setChildren(Arrays.asList(child1, child2));
		
		em.persist(child1);
		em.persist(child2);
		em.persist(p);
		
		Query q = em.createQuery("select p");
		System.out.println("select p from Person p where p.firstName='Arek'" + q.getResultList().size());
	}
	
	public void criteriaBuilder(){
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Person> q = cb.createQuery(Person.class);
		Root<Person> person = q.from(Person.class);
		q.select(person);
	}

    public void criteriaBuilderJoin() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> person = q.from(Person.class);
        //EntityType<Person> Person_ =  person.getModel();
        
       
        Join<Person, Pesel> join = person.join(Person_.pesel, JoinType.LEFT);
        q.select(person).where(cb.equal(join.get(Pesel_.value), "3434"));
        
        List<Person> list = em.createQuery(q).getResultList();
        
        for (Person p: list){
            this.log.info("person:" + p.getId());
        }
        
        //CriteriaQuery<Person> result = q.select(person);
        //result.
    }
    
    public void criteriaBuilderSubquery() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> person  = q.from(Person.class);
        
        Subquery<Integer> sq = q.subquery(Integer.class);
        Root<Manager> manager = sq.from(Manager.class);
        //sq.select(manager.get(Manager_.empId));
        
        q.select(person).where(cb.gt(person.get(Person_.id), cb.all(sq)));
        em.createQuery(q).getResultList();
        
    }
    
    public void criteriaBuilderGrouping() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Tuple> q = cb.createTupleQuery();
        Root<Person> person = q.from(Person.class);
        q.groupBy(person.get(Person_.firstName));
        q.having(cb.gt(cb.count(person.get(Person_.id)), Integer.valueOf(3)));
        q.select(cb.tuple(person.get(Person_.firstName), cb.count(person.get(Person_.id))));
        q.orderBy(cb.asc(person.get(Person_.firstName)));
        
        em.createQuery(q).getResultList();
    }
    
    public void criteriaBuildeWithNoMetamodel() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<String> q = cb.createQuery(String.class);
        Root<Person> person = q.from(Person.class);
        q.select(person.<String>get("firstName"));
        em.createQuery(q).getResultList();
    }
    
    
	public void concreteClass(){
	    Manager manager = new Manager();
	    manager.setFirstName("Wiktor");
	    manager.setLastName("Hugo");
	    manager.setSalary("big salary");
	    Address address = new Address();
	    address.setStreet("Kosciuszki");
	    manager.setAddress(address);
	    em.persist(address); // otherwise IllegalStateException
	    em.persist(manager);
	    
	}
	
	public void joinedInheritance(){
	    Cat cat = new Cat();
	    cat.setLifespan(7L);
	    cat.setMilk("a lot");
	    cat.setTailLength(18L);
	    em.persist(cat);
	    
	    em.createQuery("select cat from Cat cat").getResultList();
	}
	
	public void singleInheritance(){
	    Apple apple = new Apple();
	    apple.setCalories(100L);
	    apple.setFat(3L);
	    apple.setOrigin("Poland");
	    em.persist(apple);
	}
	
	public void lifycle(){
	    World world = new World();
	    world.setName("Earth");
	    log.info("persisting");
	    em.persist(world);
	    log.info("persisted");
	    world.setName("earth");
	    log.info("flushing...");
	    em.flush();
	    log.info("flushed");
	    log.info("refreshing...");
	    em.refresh(world);
	    log.info("refreshed");
	    log.info("world:" + world.getName());
	    log.info("detach");
	    em.detach(world);
	    log.info("merge...");
	    em.merge(new World());
	}
	
	
	void lockOptimistic(){
	    World  world = em.find(World.class, 1L);
	    //world.setArekVersion(2);
	    em.lock(world, LockModeType.OPTIMISTIC_FORCE_INCREMENT); // WRITE
	    // em.lock(world, LockModeType.OPTIMISTIC); // READ
	    // prevents from dirty read and non-repeatable read
	   
	    log.info("world: " + world.getName());
	    log.info("refreshing...");
	    em.refresh(world);
	    //world.setName("Cuyd");
	    log.info("cat" +  world.getName() + " version: " + world.getArekVersion());
	    
	    /*
	     * For versioned objects, it is permissible for an implementation to use LockMode-
Type.OPTIMISTIC_FORCE_INCREMENT where LockModeType.OPTIMISTIC was requested,
but not vice versa.
	     */
	    
	    /*
	     * The persistence implementation is not required to support calling lock(entity, LockMode-
Type.OPTIMISTIC) on a non-versioned object
	     */
	    
	    /*
	     * The persistence implementation is not required to support calling lock(entity, LockMode-
Type.OPTIMISTIC_FORCE_INCREMENT) on a non-versioned obje
	     */
	    
	    
	    /*
	     * the OptimisticLockException may be thrown in the "before
completion" phase of the commit.
	     */
	}
	
	void pesimisticLock(){
	    World  world = em.find(World.class, 1L);
        //world.setArekVersion(2);
        em.lock(world, LockModeType.PESSIMISTIC_READ); 
        
        /*
         * WRITE OR READ prevents from:
         * 
         * dirty read and Non-repeatable read
         * 
         * 
         * Any such lock must be obtained immediately and retained until transaction T1 completes
         */
        
        /*
         * When lock(entity, LockModeType.PESSIMISTIC_READ), lock(entity, Lock-
ModeType.PESSIMISTIC_WRITE), or lock(entity, LockModeType.PESSIMISTIC_-
FORCE_INCREMENT)is invoked on a versioned entity that is already in the persistence context, the
provider must also perform optimistic version checks when obtaining the lock
         */
        
        /*
         * The persistence implementation is not required to support calling lock(entity, LockMode-
Type.PESSIMISTIC_FORCE_INCREMENT) on a non-versioned object
         */
        
        /*
         * For versioned objects, it is permissible for an implementation to use LockMode-
Type.PESSIMISTIC_FORCE_INCREMENT where LockModeType.PESSIMISTIC_READ or
LockModeType.PESSIMISTIC_WRITE was requested, but not vice versa
         */
        
	}
	
	void cache(){
	    World  world = em.find(World.class, 1L);
	    log.info("world: " + world.getName());
	    World  world2 = em.find(World.class, 1L);
	    log.info("world2: " + world2.getName());
	    

        em.setProperty("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
    
	   
	    Map<String,Object> properties = new HashMap<String, Object>();
	    properties.put("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);	
	    World world3 = em.find(World.class, 1L, properties);
	    log.info("world3: " + world3.getName());
	     
	    }
	
	public static void main(String[] args) {
		
		JpaTest test = new JpaTest();
		test.em.getTransaction().begin();
		//test.create();
		//test.find();
		//test.lock();
		//test.queries();
		//test.queriesFetch();
		
		//test.criteriaBuilder();
		//test.criteriaBuilderJoin();
		
		//test.criteriaBuilderSubquery();
		//test.criteriaBuilderGrouping();
		test.criteriaBuildeWithNoMetamodel();
		    
		//test.concreteClass();
		//test.joinedInheritance();
		//test.singleInheritance();
		
		
		//test.lockOptimistic();
		//test.lifycle();
	
		//test.cache();
		
		test.em.getTransaction().commit();
		
		test.em.close();
		test.emf.close();
		

	}
}
