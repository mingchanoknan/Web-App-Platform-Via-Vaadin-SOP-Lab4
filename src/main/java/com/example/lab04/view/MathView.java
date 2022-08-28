package com.example.lab04.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Route(value = "index1")
public class MathView extends Div {
    public MathView() {
        TextField n1 = new TextField();
        n1.setLabel("Number 1");
        TextField n2 = new TextField();
        n2.setLabel("Number 2");
        TextField ans = new TextField();
        ans.setLabel("Answer");
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        verticalLayout.add(n1);
        verticalLayout.add(n2);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button plus = new Button("+");
        Button minus = new Button("-");
        Button multi = new Button("x");
        Button divide = new Button("/");
        Button mod = new Button("Mod");
        Button max = new Button("Max");
        horizontalLayout.add(plus);
        horizontalLayout.add(minus);
        horizontalLayout.add(multi);
        horizontalLayout.add(divide);
        horizontalLayout.add(mod);
        horizontalLayout.add(max);
        verticalLayout.add(horizontalLayout);
        verticalLayout.add(ans);
        this.add(verticalLayout);

        //events and listeners
        plus.addClickListener(event ->{
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            Double out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(Double.class)
                    .block();
            ans.setValue(String.valueOf(out));
        });

        minus.addClickListener(event ->{
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            Double out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(Double.class)
                    .block();
            ans.setValue(String.valueOf(out));
        });

        multi.addClickListener(event ->{
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            Double out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(Double.class)
                    .block();
            ans.setValue(String.valueOf(out));
        });
        divide.addClickListener(event ->{
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            Double out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(Double.class)
                    .block();
            ans.setValue(String.valueOf(out));
        });
        mod.addClickListener(event ->{
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            Double out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(Double.class)
                    .block();
            ans.setValue(String.valueOf(out));
        });
        max.addClickListener(event ->{
            MultiValueMap<String,String> formdata = new LinkedMultiValueMap<>();
            formdata.add("n1",n1.getValue());
            formdata.add("n2",n2.getValue());

            Double out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formdata))
                    .retrieve()
                    .bodyToMono(Double.class)
                    .block();
            ans.setValue(String.valueOf(out));
        });
    }
}
