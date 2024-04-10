package edu.avale1648.classwork_2024_03_22.pgsql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import edu.avale1648.classwork_2024_03_22.pgsql.entities.MathResult;
import edu.avale1648.classwork_2024_03_22.pgsql.entities.Question;

public class StoreData implements AutoCloseable {
	private final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
			.configure("hibernate.cfg.xml").build();
	private final Metadata METADATA = new MetadataSources(REGISTRY).getMetadataBuilder()
			.build();
	private final SessionFactory SESSION_FACTORY = METADATA.getSessionFactoryBuilder()
			.build();
	private final Session SESSION = SESSION_FACTORY.openSession();
	private final Transaction TRANSACTION = SESSION.beginTransaction();

	public void saveQuestion(Question question) {
		save(question);
	}

	public void saveResult(Question question, String answer) {

		MathResult m = new MathResult(question, answer);
		save(m);
	}

	public Question getQuestion(int id) {
		Question q = (Question) SESSION.get(Question.class, id);
		return q;
	}

	public void save(Object object) {
		SESSION.persist(object);
		TRANSACTION.commit();
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		SESSION_FACTORY.close();
		SESSION.close();
	}
}
