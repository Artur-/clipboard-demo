package com.example.clipboard;

import java.util.Collections;
import java.util.List;

/**
 * Stub for the clipboard event that will be passed to paste/copy/cut
 * listeners. Returns empty/null values since the API is not yet implemented.
 */
public class ClipboardEvent {

    public String getText() {
        return "";
    }

    public String getHtml() {
        return "";
    }

    public boolean hasText() {
        return false;
    }

    public boolean hasHtml() {
        return false;
    }

    public boolean hasFiles() {
        return false;
    }

    public List<ClipboardFile> getFiles() {
        return Collections.emptyList();
    }
}
