package com.example.vaad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    Grid<Birimler> grid=new Grid<> (Birimler.class);
    Birimler bir=new Birimler();
    TextField tf=new TextField("Güncelleme");
	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	KayitCek ss=new KayitCek();
    	Label lbl=new Label();
    	Button save = new Button("save");
    	save.addClickListener(this :: saveListener);
    	lbl.setCaption(ss.getBirimlerTablosu().iterator().next().getBIRIMADI());
    	VerticalLayout v=new VerticalLayout();
    	
    	v.addComponents(lbl,grid,save,tf);
    	setContent(v);
    	grid.setItems(ss.getBirimlerTablosu());
    	
    }
	private void saveListener(Button.ClickEvent clickEvent){
	    HashSet test=(HashSet) grid.getSelectedItems();
	    Birimler bir=(Birimler) test.iterator().next();
	    System.out.println("adı " + bir.getBIRIMADI());
	    tf.setValue(bir.getBIRIMADI());
	    grid.clearSortOrder();
	}


	

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
