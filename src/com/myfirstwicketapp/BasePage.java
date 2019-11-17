package com.myfirstwicketapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public abstract class BasePage extends WebPage {
	
	public BasePage(){
		
		
		Link movieLink = new Link("movies"){

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				setResponsePage(Movies.class);
				
			}
			
		};
		
		Link televisionLink = new Link("television"){

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				setResponsePage(Television.class);
				
			}
			
		};
		
		Link eventLink = new Link("events"){

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				setResponsePage(Events.class);
				
			}
			
		};
		
		Link loginLink = new Link("login"){

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				setResponsePage(LoginPage.class);
				
			}
			
		};
		
		
		
		
		add(movieLink);
		add(televisionLink);
		add(eventLink);
add(loginLink);
		
		
		
		
	}

}
