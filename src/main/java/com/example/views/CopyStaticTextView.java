package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Pre;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "copy-static-text", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Copy Static Text")
public class CopyStaticTextView extends VerticalLayout {

    public CopyStaticTextView() {
        add(new H2("1. Copy Static Text on Button Click"));
        add(new Paragraph(
                "The most common case. Text is known when the view is rendered. "
                        + "Executes entirely on the client — works in all browsers."));

        String link = "https://example.com/share/abc123";
        add(new Paragraph("Text to copy:"));
        add(new Pre(link));

        Button copyButton = new Button("Copy link");
        Clipboard.copyOnClick(copyButton, link,
                () -> Notification.show("Link copied!"),
                () -> Notification.show("Copy failed"));
        add(copyButton);

        add(stubNote());
    }

    static Paragraph stubNote() {
        Paragraph note = new Paragraph(
                "Note: Clipboard operations are not yet functional — "
                        + "the API is a stub for demonstration purposes.");
        note.getStyle().set("color", "var(--lumo-secondary-text-color)")
                .set("font-style", "italic")
                .set("margin-top", "var(--lumo-space-l)");
        return note;
    }
}
