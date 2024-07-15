package mapping;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class Test
{
	public static void main(String[] args)
	{
		Transaction tr=null;
		try(Session ses=HBUtil.getSessionFactory().openSession())
		{
			tr=ses.beginTransaction();
			Answer a1=new Answer();
			a1.setAnswername("one answer");
			a1.setPostedBy("Dhinessh");
			Answer a2=new Answer();
			a2.setAnswername("Second Answer");
			a2.setPostedBy("Dillep");
			List<Answer> li=new ArrayList<Answer>();
			li.add(a1);
			li.add(a2);
			Question q1=new Question();
			q1.setQname("first question");
			q1.setAnswers(li);
			ses.merge(q1);
			tr.commit();	
		    ses.close();
		}
		catch(Exception e ) 
		{
			e.printStackTrace();
	    }
	}
}

