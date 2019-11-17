package com.myfirstwicketapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UserDataProvider extends SortableDataProvider<User> {
	
	List<User> userdb= new ArrayList<User>();
	
	public UserDataProvider(){
		for(int i=0;i<100;i++){
			User user=new User();
			user.setUsername("Username"+i);
			user.setPassword("password"+i);
			userdb.add(user);
		}
	}
	
	
	
	

	@Override
	public Iterator<? extends User> iterator(int first, int count) {
		List<User> tmpList = new ArrayList<User>(userdb);
		return tmpList.subList(first, first+count).iterator();
	}

	@Override
	public IModel<User> model(User arg0) {
		 
		return new LoadableDetachableModel<User>() {

			@Override
			protected User load() {
				// TODO Auto-generated method stub
				return arg0;
			}
			
		};
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return userdb.size();
	}
	
	

}
