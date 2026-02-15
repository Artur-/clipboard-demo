package com.example.clipboard;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Stub for a file received via clipboard paste.
 * Returns dummy values since the API is not yet implemented.
 */
public class ClipboardFile {

    public String getName() {
        return "";
    }

    public String getMimeType() {
        return "application/octet-stream";
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(new byte[0]);
    }

    public long getSize() {
        return 0;
    }
}
