package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "copy-cut-events", layout = MainLayout.class)
@PageTitle("Copy/Cut Events")
public class CopyCutEventsView extends VerticalLayout {

    public CopyCutEventsView() {
        add(new H2("12. Listen for Copy/Cut Events"));
        add(new Paragraph(
                "Track when content is copied or cut from a component."));

        TextArea codeBlock = new TextArea("Select and copy/cut text below");
        codeBlock.setValue(
                "function hello() {\n  console.log('Hello, world!');\n}");
        codeBlock.setWidthFull();
        codeBlock.setHeight("150px");

        Span log = new Span("Event log will appear here...");
        log.getStyle()
                .set("font-family", "monospace")
                .set("white-space", "pre-wrap")
                .set("padding", "var(--lumo-space-s)")
                .set("background", "var(--lumo-contrast-5pct)")
                .set("display", "block")
                .set("border-radius", "var(--lumo-border-radius-m)");

        Clipboard.addCopyListener(codeBlock, event -> {
            log.setText("Copy event detected!");
        });

        Clipboard.addCutListener(codeBlock, event -> {
            log.setText("Cut event detected!");
        });

        add(codeBlock, log);
        add(CopyStaticTextView.stubNote());
    }
}
