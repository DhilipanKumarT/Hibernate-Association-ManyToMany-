package mapping;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HBUtil 
{
		private static SessionFactory sessionFactory;
		public static SessionFactory getSessionFactory()
		{
			if(sessionFactory==null)
			{
				try
				{
					Metadata md=new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build()).buildMetadata();
					sessionFactory=md.buildSessionFactory();
				}
				catch(HibernateException h) {h.printStackTrace();}
			}
			return sessionFactory;
		}

	}
