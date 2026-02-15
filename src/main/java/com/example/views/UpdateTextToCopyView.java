package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.example.clipboard.ClipboardCopy;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "update-text-to-copy", layout = MainLayout.class)
@PageTitle("Update Text to Copy")
public class UpdateTextToCopyView extends VerticalLayout {

    private int counter = 0;

    public UpdateTextToCopyView() {
        add(new H2("3. Update the Text to Copy"));
        add(new Paragraph(
                "The text changes based on server-side state. "
                        + "Set up the click handler once, push updates to the stored value."));

        String initialCode = generateInviteCode();
        Span codeDisplay = new Span(initialCode);
        codeDisplay.getStyle()
                .set("font-family", "monospace")
                .set("font-size", "var(--lumo-font-size-xl)")
                .set("padding", "var(--lumo-space-m)")
                .set("background", "var(--lumo-contrast-5pct)")
                .set("border-radius", "var(--lumo-border-radius-m)");

        Button copyButton = new Button("Copy code");
        ClipboardCopy handle = Clipboard.copyOnClick(copyButton, initialCode);

        Button generateButton = new Button("Generate new code", e -> {
            String code = generateInviteCode();
            codeDisplay.setText(code);
            handle.setValue(code);
        });

        add(codeDisplay);
        add(new HorizontalLayout(generateButton, copyButton));
        add(CopyStaticTextView.stubNote());
    }

    private String generateInviteCode() {
        counter++;
        return "INVITE-" + String.format("%04d", counter) + "-"
                + Long.toHexString(System.currentTimeMillis()).toUpperCase();
    }
}
