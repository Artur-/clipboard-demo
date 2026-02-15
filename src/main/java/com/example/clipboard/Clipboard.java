package com.example.clipboard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.shared.Registration;

/**
 * Stub Clipboard API mirroring the proposed Vaadin Flow Clipboard API
 * (GitHub issue #17703). All methods are no-ops since the API is not yet
 * implemented.
 */
public interface Clipboard {

    // --- Client-side copy (reliable, no round-trip) ---

    static ClipboardCopy copyOnClick(Component trigger, String text) {
        return new ClipboardCopy();
    }

    static ClipboardCopy copyOnClick(Component trigger, String text,
            Runnable onSuccess, Runnable onError) {
        return new ClipboardCopy();
    }

    static ClipboardCopy copyOnClick(Component trigger,
            HasValue<?, ?> source) {
        return new ClipboardCopy();
    }

    static ClipboardCopy copyImageOnClick(Component trigger, Image source) {
        return new ClipboardCopy();
    }

    // --- Server-initiated clipboard operations ---

    static void writeText(String text) {
        // no-op stub
    }

    static void writeText(String text, Runnable onSuccess,
            SerializableConsumer<String> onError) {
        // no-op stub
    }

    static void readText(SerializableConsumer<String> callback) {
        // no-op stub
    }

    static void writeImage(String url) {
        // no-op stub
    }

    static void writeImage(StreamResource resource) {
        // no-op stub
    }

    // --- Event listeners ---

    static Registration addPasteListener(Component target,
            SerializableConsumer<ClipboardEvent> listener) {
        return () -> {};
    }

    static Registration addCopyListener(Component target,
            SerializableConsumer<ClipboardEvent> listener) {
        return () -> {};
    }

    static Registration addCutListener(Component target,
            SerializableConsumer<ClipboardEvent> listener) {
        return () -> {};
    }
}
