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

@Route(value = "copy-image", layout = MainLayout.class)
@PageTitle("Copy Image")
public class CopyImageView extends VerticalLayout {

    private static final String CHART_SVG = """
            <svg xmlns="http://www.w3.org/2000/svg" width="300" height="200">
              <rect width="300" height="200" fill="#4A90D9"/>
              <text x="150" y="40" text-anchor="middle" fill="white"
                    font-size="20" font-family="sans-serif">Sample Chart</text>
              <rect x="40"  y="110" width="40" height="60"  fill="#81B5E8"/>
              <rect x="90"  y="90"  width="40" height="80"  fill="#81B5E8"/>
              <rect x="140" y="70"  width="40" height="100" fill="#81B5E8"/>
              <rect x="190" y="100" width="40" height="70"  fill="#81B5E8"/>
              <rect x="240" y="120" width="40" height="50"  fill="#81B5E8"/>
            </svg>
            """;

    public CopyImageView() {
        add(new H2("6. Copy an Image to Clipboard"));
        add(new Paragraph(
                "Copy an image to the clipboard from a URL."));

        StreamResource resource = new StreamResource("chart.svg",
                () -> new ByteArrayInputStream(
                        CHART_SVG.getBytes(StandardCharsets.UTF_8)));
        resource.setContentType("image/svg+xml");

        Image preview = new Image(resource, "Sample chart");
        preview.setWidth("300px");
        add(preview);

        Button copyButton = new Button("Copy image", e -> {
            Clipboard.writeImage("/images/chart.png");
        });
        add(copyButton);

        add(CopyStaticTextView.stubNote());
    }
}
