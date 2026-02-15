package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.example.clipboard.ClipboardFile;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "paste-images", layout = MainLayout.class)
@PageTitle("Paste Images")
public class PasteImagesView extends VerticalLayout {

    public PasteImagesView() {
        add(new H2("10. Listen for Paste — Images"));
        add(new Paragraph(
                "Handle pasted images (e.g., screenshots). "
                        + "Image data is sent to the server via the upload mechanism."));

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
        dropZone.setText("Paste an image here (Ctrl+V / Cmd+V)");
        dropZone.setWidthFull();

        Span log = new Span("Image paste log will appear here...");
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
                if (file.getMimeType().startsWith("image/")) {
                    sb.append("Image: ").append(file.getName())
                            .append(" (").append(file.getMimeType())
                            .append(", ").append(file.getSize())
                            .append(" bytes)\n");
                }
            }
            if (sb.length() > 0) {
                log.setText(sb.toString());
            }
        });

        add(dropZone, log);
        add(CopyStaticTextView.stubNote());
    }
}
