package com.example.springshop.frontend;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainView extends VerticalLayout {
    public MainView() {
        var titleHL = new HorizontalLayout();
        var textHL = new HorizontalLayout();

        var title = new Text("Проверка связи");
        var titleButton = new Button("Нажми меня");
        titleButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                System.out.println("тест");
            }
        });

        var text = new Text("А здесь чуть ниже");

        titleHL.add(title, titleButton);
        textHL.add(text);

        add(titleHL, textHL);
    }
}
