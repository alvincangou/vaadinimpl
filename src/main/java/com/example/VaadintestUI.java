package com.example;
import Dao.mapping.UserVisite;
import com.vaadin.addon.charts.*;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.annotations.Widgetset;
import Dao.mapping.UserEntity;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

import services.HelloService;
import services.HelloServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


@Widgetset("com.example.WidgetSet")
@Theme("mytheme")
public class VaadintestUI extends UI {
	/*private JPAContainer<UserEntity> dataS = JPAContainerFactory.make(
				            UserEntity.class, "persistance");*/
	Table table = new Table("My Table");
BeanItemContainer<UserEntity> container = new BeanItemContainer<UserEntity>(UserEntity.class);
	BeanItemContainer<UserVisite> container2 = new BeanItemContainer<UserVisite>(UserVisite.class);

	private Container.Indexed datasource;

userDAO user = new userDAO();
int i;
Chart chart = new Chart();


	RangeSelector rangeSelector = new RangeSelector();
Configuration conf = chart.getConfiguration();
Navigator navigator = conf.getNavigator();

DataSeries data = new DataSeries("visite");



DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
//String d ="2017-02-19";
//Date inputDate = dateFormat.parse(d);

//List<Object[]> countdate= user.afficherCOUNTperDate(inputDate);
List<UserEntity> count0 = user.afficherTout();

List<Object[]> count1= user.afficherCOUNT();

List<Object[]> count2= user.afficherCOUNT2();

List<UserVisite> count3= user.afficherCOUNT3();



private	String bonjour;
private 	HelloService helloService = new HelloServiceImpl();
private	Label lab = new Label("bienvenue");
private Label hello = new Label();
private	Button b =new Button("valider");
private VerticalLayout bienvenue =new VerticalLayout();
private VerticalLayout layout =new VerticalLayout();

	public VaadintestUI() throws ParseException {
	}




	protected void init(VaadinRequest request){
		//rangeSelector.setInputDateFormat("%YYYY-%MM-%DD");
		//rangeSelector.setInputEditDateFormat("%YYYY-%MM-%DD");

		chart.addPointClickListener(new PointClickListener() {
											@Override
											public void onClick(PointClickEvent event) {
												Notification.show("Vous clickez sur "+event.getY());

											}
										});

				rangeSelector.setInputDateParser(
						"function(value) {" +
								"value = value.split(/[:\\-]/);\n" +
								"return Date.UTC(\n" +
								"   parseInt(value[0], 10),\n" +
								"   parseInt(value[1], 10),\n" +
								"   parseInt(value[2], 10),\n" +

								");}");
		conf.setRangeSelector(rangeSelector);
		chart.setTimeline(true);
		navigator.setEnabled(true);

		navigator.setMargin(75);
		PlotOptionsColumn plotOptions= new PlotOptionsColumn();
		plotOptions.setColor(SolidColor.CHOCOLATE);
		plotOptions.setGetExtremesFromAll(true);
		conf.setPlotOptions(plotOptions);



		PlotOptionsSeries plotOptionsT= new PlotOptionsSeries();
		plotOptionsT.setColor(SolidColor.CHOCOLATE);
		navigator.setSeries(plotOptionsT);
		navigator.setAdaptToUpdatedData(true);


	//	container.addAll(count0);
		container2.addAll(count3);
		this.datasource =  container2;
		chart.drawChart(conf);


		/*Timeline timeline = new Timeline("visite");

		timeline.setUniformBarThicknessEnabled(false);
		timeline.setGraphStacking(false);
		timeline.setChartMode(Timeline.ChartMode.BAR);

		timeline.setUniformBarThicknessEnabled(true);
		timeline.setDateSelectVisible(true);
		timeline.setCaption(null);
		timeline.setZoomLevelsVisible(false);
		timeline.setZoomLevelsCaption(null);

		timeline.setSizeFull();

		timeline.setVerticalAxisRange(0f, chart.getHeight() * 1.1f);
		//timeline.addGraphDataSource(datasource,"date","pk");
		timeline.addGraphDataSource(datasource,"date","count");
*/

		conf.setTitle("nombre de visite par jour");
		conf.getChart().setType(ChartType.COLUMN);
		conf.getxAxis().setTitle("Date");
		conf.getyAxis().setType(AxisType.LINEAR);
conf.getxAxis().setType(AxisType.DATETIME);
		conf.getyAxis().setTitle("visites");


		for (Object[] aRow : count2) {
			Long sum = (Long) aRow[0];
			Date date = (Date) aRow[1];

 //  int d1=date.getYear();
   // int d2=date.getMonth();
     //int d3=date.getDay();
			Date d = date;
			data.add(new DataSeriesItem(d,sum));


		}


		conf.addSeries(data);
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setMargin(true);
		//setContent(timeline);








		FormLayout form = new FormLayout();

		Label hello1 = new Label("Helloworld");
		HorizontalLayout layout1 = new HorizontalLayout();
		VerticalLayout layout2 = new VerticalLayout();
		Label test = new Label("Nom:");






	final TextField text =new TextField();
		layout1.addComponent(test);
		layout1.addComponent(text);
		layout1.setMargin(true);
		layout1.setSpacing(true);
		layout2.setSpacing(true);
		layout2.setMargin(true);
		layout2.addComponent(hello1);
		layout2.setComponentAlignment(hello1,Alignment.MIDDLE_CENTER);
		layout2.addComponent(layout1);
		layout2.setComponentAlignment(layout1,Alignment.MIDDLE_CENTER);

		layout2.addComponent(b);
		layout2.setComponentAlignment(b,Alignment.MIDDLE_CENTER);
form.addComponent(chart);
//form.addComponent(timeline);
form.addComponent(layout2);
form.setMargin(true);
form.setSpacing(true);

form.setComponentAlignment(layout2,Alignment.MIDDLE_CENTER);
//b.addClickListener(event ->  getPage().setLocation("/hello"));
		b.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				Notification.show("hello "+text.getValue());
				b.setCaption("Sending");
				bonjour = helloService.sayhello(text.getValue());
hello.setCaption(bonjour);
bienvenue.addComponent(lab);
bienvenue.addComponent(hello);

setContent(bienvenue);

			}

		});
	//	b.addClickListener(e ->Notification.show("hello "+text.getValue()));
		setContent(form);
	}
    public void updateList() {
        // fetch list of Customers from service and assign it to Grid
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = VaadintestUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
