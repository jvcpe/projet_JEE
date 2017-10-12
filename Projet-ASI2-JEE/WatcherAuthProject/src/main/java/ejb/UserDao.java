package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.cpe.model.UserModel;

@Stateless
public class UserDao {

	@PersistenceContext
	EntityManager primary;
	
	
	public UserModel getUserModelById(int id){
		
		UserModel util = (UserModel)primary.createQuery("from utilisateurs u where u.id = :id")
					.setParameter("id", id)
					.getSingleResult();
		return util;
	}
	
	public List<UserModel> getUserModelList(){
		
		List<UserModel> userList = new ArrayList<UserModel>();
		
		userList = (List<UserModel>)primary.createQuery("from UserModel").getResultList();
		
		return userList;
	}
}
