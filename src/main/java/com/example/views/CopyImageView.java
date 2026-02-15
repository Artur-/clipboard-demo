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

@Route(value = "copy-image", layout = MainLayout.class)
@PageTitle("Copy Image")
public class CopyImageView extends VerticalLayout {

    public CopyImageView() {
        add(new H2("6. Copy an Image to Clipboard"));
        add(new Paragraph(
                "Copy an image to the clipboard from a URL."));

        String imageUrl = "https://via.placeholder.com/300x200.png?text=Sample+Chart";

        Image preview = new Image(imageUrl, "Sample chart");
        preview.setWidth("300px");
        add(preview);

        Button copyButton = new Button("Copy image", e -> {
            Clipboard.writeImage(imageUrl);
        });
        add(copyButton);

        add(CopyStaticTextView.stubNote());
    }
}
