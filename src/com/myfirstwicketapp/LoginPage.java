package com.myfirstwicketapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends BasePage {

	public LoginPage() {
		
		
		ModalWindow helpWindow= new ModalWindow("help");
		
		
		helpWindow.setPageCreator(new ModalWindow.PageCreator() {
			
			@Override
			public Page createPage() {
				// TODO Auto-generated method stub
				return new CopyRightPage();
			}
		});
		helpWindow.setTitle(new Model("Help"));
		
		helpWindow.setOutputMarkupId(true);
		
		AjaxLink help=new AjaxLink("help_link")
		{
			
			@Override
			public void onClick(AjaxRequestTarget arg0) {
				helpWindow.show(arg0);
				
			}
			
		};
		
		User user = new User();
		FeedbackPanel feedback_panel = new FeedbackPanel("error_messages");
		
		Form loginForm = new Form("loginForm");
		Label username_label = new Label("username_label" , "Username");
		Label password_label = new Label("password_label", "Password");

		TextField<String> username = new TextField<String>("username", new PropertyModel(user, "username"));
		username.setRequired(true);
		username.add(new UserNameValidator());

		PasswordTextField password = new PasswordTextField("password", new PropertyModel(user, "password"));
		password.setRequired(true);

		Button login_button = new Button("login_button") {
			@Override
			public void onSubmit() {
				System.out.println("Will handle all the login concerns here");
				System.out.println("Username" + user.getUsername());
				System.out.println("Password " + user.getPassword());

				getApplication().getSessionStore().setAttribute(getRequest(), "logged_in", "logged_in");

				setResponsePage(HomePage.class);
			}
		};

		loginForm.add(username_label);
		loginForm.add(password_label);
		loginForm.add(username);
		loginForm.add(password);
		loginForm.add(login_button);
		add(feedback_panel);
		add(loginForm);
		add(help);
		add(helpWindow);
		
		
		
		
		//##########################With pagination starts#####################################
		IColumn[] column2=new IColumn[2];
		
		column2[0]=new PropertyColumn<>(new Model("Username"),"username","Username");
		column2[1]=new PropertyColumn<>(new Model("Password"),"Password","Password");
		
		DefaultDataTable table = new DefaultDataTable<>("datatable", column2, new UserDataProvider(), 10);
		
		add(table);
		//##########################With pagination ends#####################################
		
		//##########################Without pagination starts#####################################
		
		
		
		
		List<ICellPopulator<User>> columns=new ArrayList<>();
		columns.add(new PropertyPopulator<>("Username"));
		columns.add(new PropertyPopulator<>("Password"));
		DataGridView view = new DataGridView("rows", columns, new UserDataProvider());
		
		add(view);
		
		//##########################With pagination ends#####################################
		
		
		
		
		
		
		
		
	}


}
