package com.example.views;

import com.example.MainLayout;
import com.example.clipboard.Clipboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "read-clipboard-text", layout = MainLayout.class)
@PageTitle("Read Clipboard Text")
public class ReadClipboardTextView extends VerticalLayout {

    public ReadClipboardTextView() {
        add(new H2("5. Read Text from Clipboard"));
        add(new Paragraph(
                "Programmatically read clipboard text. "
                        + "Subject to browser permissions."));

        TextField textField = new TextField("Clipboard content");
        textField.setWidthFull();
        textField.setReadOnly(true);

        Button pasteButton = new Button("Paste from clipboard", e -> {
            Clipboard.readText(text -> textField.setValue(text));
        });

        add(pasteButton, textField);
        add(CopyStaticTextView.stubNote());
    }
}
