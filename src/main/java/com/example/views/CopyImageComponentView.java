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

@Route(value = "copy-image-component", layout = MainLayout.class)
@PageTitle("Copy Image Component")
public class CopyImageComponentView extends VerticalLayout {

    public CopyImageComponentView() {
        add(new H2("7. Copy an Image Component's Content"));
        add(new Paragraph(
                "Copy the content of a Vaadin Image component. "
                        + "On click, fetches the image as a blob client-side and writes to clipboard."));

        Image chartImage = new Image(
                "https://via.placeholder.com/300x200.png?text=Chart+Image",
                "Chart");
        chartImage.setWidth("300px");
        add(chartImage);

        Button copyButton = new Button("Copy chart");
        Clipboard.copyImageOnClick(copyButton, chartImage);
        add(copyButton);

        add(CopyStaticTextView.stubNote());
    }
}
