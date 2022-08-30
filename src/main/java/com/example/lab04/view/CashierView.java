package com.example.lab04.view;

import com.example.lab04.model.Change;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route("/index2")
public class CashierView extends Div {
    public CashierView() {
        VerticalLayout layout = new VerticalLayout();
        TextField change = new TextField();
        change.setPrefixComponent(new Span("$"));
        change.setLabel("เงินทอน");

        Button cal = new Button("คำนวณเงินทอน");

        TextField b1000 = new TextField();
        b1000.setReadOnly(true);
        b1000.setPrefixComponent(new Span("$1000: "));
        TextField b500 = new TextField();
        b500.setReadOnly(true);
        b500.setPrefixComponent(new Span("$500:"));
        TextField b100 = new TextField();
        b100.setReadOnly(true);
        b100.setPrefixComponent(new Span("$100: "));
        TextField b20 = new TextField();
        b20.setReadOnly(true);
        b20.setPrefixComponent(new Span("$20: "));
        TextField b10 = new TextField();
        b10.setReadOnly(true);
        b10.setPrefixComponent(new Span("$10: "));
        TextField b5 = new TextField();
        b5.setReadOnly(true);
        b5.setPrefixComponent(new Span("$5: "));
        TextField b1 = new TextField();
        b1.setReadOnly(true);
        b1.setPrefixComponent(new Span("$1: "));

        layout.add(change, cal, b1000, b500, b100, b20, b10, b5, b1);
        this.add(layout);

//        Event
        cal.addClickListener(event -> {
            int newChange = Integer.parseInt(change.getValue());

            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getchange/"+ newChange)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            b1000.setValue(String.valueOf(out.getB1000()));
            b500.setValue(String.valueOf(out.getB500()));
            b100.setValue(String.valueOf(out.getB100()));
            b20.setValue(String.valueOf(out.getB20()));
            b10.setValue(String.valueOf(out.getB10()));
            b5.setValue(String.valueOf(out.getB5()));
            b1.setValue(String.valueOf(out.getB1()));

        });

    }

}
