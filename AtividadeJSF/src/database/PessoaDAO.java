package database;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidades.Pessoa;

public class PessoaDAO {

	public void inserir(Pessoa pessoa) {
		Session session = JPAUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(pessoa);
			session.getTransaction().commit();
		} catch (HibernateException hex) {
			session.getTransaction().rollback();
			hex.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	public List<Pessoa> getAll() {
		Session session = JPAUtil.getSessionFactory().openSession();
		List<Pessoa> pessoas = null;
		Query query;

		try {
			session.beginTransaction();
			query = session.getNamedQuery("Pessoa.getAll");
			pessoas = query.list();
			session.getTransaction().commit();
		} catch (HibernateException hexp) {
			session.getTransaction().rollback();
			hexp.printStackTrace();
		} finally {
			session.close();
			return pessoas;
		}
	}

}
