package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.example.clipboard.ClipboardFile;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "paste-files", layout = MainLayout.class)
@PageTitle("Paste Files")
public class PasteFilesView extends VerticalLayout {

    public PasteFilesView() {
        add(new H2("11. Listen for Paste — Any Files"));
        add(new Paragraph(
                "Handle arbitrary pasted files."));

        Div dropZone = new Div();
        dropZone.getStyle()
                .set("border", "2px dashed var(--lumo-contrast-30pct)")
                .set("padding", "var(--lumo-space-xl)")
                .set("text-align", "center")
                .set("border-radius", "var(--lumo-border-radius-l)")
                .set("min-height", "150px")
                .set("display", "flex")
                .set("align-items", "center")
                .set("justify-content", "center");
        dropZone.setText("Paste any file here (Ctrl+V / Cmd+V)");
        dropZone.setWidthFull();

        Span log = new Span("File paste log will appear here...");
        log.getStyle()
                .set("font-family", "monospace")
                .set("white-space", "pre-wrap")
                .set("padding", "var(--lumo-space-s)")
                .set("background", "var(--lumo-contrast-5pct)")
                .set("display", "block")
                .set("border-radius", "var(--lumo-border-radius-m)");

        Clipboard.addPasteListener(dropZone, event -> {
            StringBuilder sb = new StringBuilder();
            for (ClipboardFile file : event.getFiles()) {
                sb.append("File: ").append(file.getName())
                        .append(" (").append(file.getMimeType())
                        .append(", ").append(file.getSize())
                        .append(" bytes)\n");
            }
            if (sb.length() > 0) {
                log.setText(sb.toString());
            }
        });

        add(dropZone, log);
        add(CopyStaticTextView.stubNote());
    }
}
