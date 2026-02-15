package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Route(value = "copy-image-component", layout = MainLayout.class)
@PageTitle("Copy Image Component")
public class CopyImageComponentView extends VerticalLayout {

    private static final String CHART_SVG = """
            <svg xmlns="http://www.w3.org/2000/svg" width="300" height="200">
              <rect width="300" height="200" fill="#D94A4A"/>
              <text x="150" y="40" text-anchor="middle" fill="white"
                    font-size="20" font-family="sans-serif">Chart Image</text>
              <circle cx="80"  cy="140" r="30" fill="#E88181"/>
              <circle cx="160" cy="150" r="20" fill="#E88181"/>
              <circle cx="230" cy="130" r="40" fill="#E88181"/>
            </svg>
            """;

    public CopyImageComponentView() {
        add(new H2("7. Copy an Image Component's Content"));
        add(new Paragraph(
                "Copy the content of a Vaadin Image component. "
                        + "On click, fetches the image as a blob client-side and writes to clipboard."));

        StreamResource resource = new StreamResource("chart.svg",
                () -> new ByteArrayInputStream(
                        CHART_SVG.getBytes(StandardCharsets.UTF_8)));
        resource.setContentType("image/svg+xml");

        Image chartImage = new Image(resource, "Chart");
        chartImage.setWidth("300px");
        add(chartImage);

        Button copyButton = new Button("Copy chart");
        Clipboard.copyImageOnClick(copyButton, chartImage);
        add(copyButton);

        add(CopyStaticTextView.stubNote());
    }
}
