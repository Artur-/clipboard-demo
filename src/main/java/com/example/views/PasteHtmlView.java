package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "paste-html", layout = MainLayout.class)
@PageTitle("Paste HTML")
public class PasteHtmlView extends VerticalLayout {

    public PasteHtmlView() {
        add(new H2("9. Listen for Paste — HTML"));
        add(new Paragraph(
                "Handle rich text paste (e.g., from a web page or document)."));

        TextArea editor = new TextArea("Paste rich content here");
        editor.setWidthFull();
        editor.setHeight("150px");
        editor.setPlaceholder(
                "Try pasting formatted text from a web page");

        Div preview = new Div();
        preview.getStyle()
                .set("border", "1px solid var(--lumo-contrast-20pct)")
                .set("padding", "var(--lumo-space-m)")
                .set("min-height", "100px")
                .set("border-radius", "var(--lumo-border-radius-m)");
        preview.setText("HTML preview will appear here...");

        Clipboard.addPasteListener(editor, event -> {
            if (event.hasHtml()) {
                String html = event.getHtml();
                preview.removeAll();
                preview.add(new Html("<div>" + html + "</div>"));
            } else {
                preview.setText(event.getText());
            }
        });

        add(editor, new Paragraph("Preview:"), preview);
        add(CopyStaticTextView.stubNote());
    }
}
