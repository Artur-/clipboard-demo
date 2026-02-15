package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "copy-from-component", layout = MainLayout.class)
@PageTitle("Copy from Component")
public class CopyFromComponentView extends VerticalLayout {

    public CopyFromComponentView() {
        add(new H2("2. Copy Value from Another Component"));
        add(new Paragraph(
                "Copy the current value of a text field. "
                        + "Value is read client-side via JS — no round-trip."));

        TextField linkField = new TextField("Share link");
        linkField.setValue("https://example.com/share/abc123");
        linkField.setWidthFull();

        Button copyButton = new Button("Copy");
        Clipboard.copyOnClick(copyButton, linkField);

        add(new HorizontalLayout(linkField, copyButton) {{
            setAlignItems(Alignment.END);
            setWidthFull();
        }});

        add(CopyStaticTextView.stubNote());
    }
}
