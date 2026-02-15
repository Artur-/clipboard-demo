package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Route(value = "copy-server-computed", layout = MainLayout.class)
@PageTitle("Copy Server-Computed Text")
public class CopyServerComputedView extends VerticalLayout {

    public CopyServerComputedView() {
        add(new H2("4. Copy Server-Computed Text on Click"));
        add(new Paragraph(
                "Text must be computed at click time on the server. "
                        + "Involves a server round-trip."));

        Paragraph warning = new Paragraph(
                "Browser compatibility note: May not work in Firefox/Safari "
                        + "due to user gesture timeout.");
        warning.getStyle().set("color", "var(--lumo-warning-text-color)")
                .set("background", "var(--lumo-warning-color-10pct)")
                .set("padding", "var(--lumo-space-s)")
                .set("border-radius", "var(--lumo-border-radius-m)");
        add(warning);

        Button copyButton = new Button("Copy report", e -> {
            String report = generateReport();
            Clipboard.writeText(report,
                    () -> Notification.show("Copied!"),
                    err -> Notification.show("Failed: " + err));
        });
        add(copyButton);

        add(CopyStaticTextView.stubNote());
    }

    private String generateReport() {
        return "Report generated at " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + "\nTotal users: 1,234\nActive today: 567";
    }
}
