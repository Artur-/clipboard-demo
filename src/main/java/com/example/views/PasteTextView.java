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

@Route(value = "paste-text", layout = MainLayout.class)
@PageTitle("Paste Text")
public class PasteTextView extends VerticalLayout {

    public PasteTextView() {
        add(new H2("8. Listen for Paste — Text"));
        add(new Paragraph(
                "React when user pastes (Ctrl+V / Cmd+V) into a component."));

        TextArea textArea = new TextArea("Paste here");
        textArea.setWidthFull();
        textArea.setHeight("200px");
        textArea.setPlaceholder("Try pasting text here with Ctrl+V / Cmd+V");

        Span log = new Span("Paste log will appear here...");
        log.getStyle()
                .set("font-family", "monospace")
                .set("white-space", "pre-wrap")
                .set("padding", "var(--lumo-space-s)")
                .set("background", "var(--lumo-contrast-5pct)")
                .set("display", "block")
                .set("border-radius", "var(--lumo-border-radius-m)");

        Clipboard.addPasteListener(textArea, event -> {
            String pastedText = event.getText();
            log.setText("Pasted text: " + pastedText);
        });

        add(textArea, log);
        add(CopyStaticTextView.stubNote());
    }
}
