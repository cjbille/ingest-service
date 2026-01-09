package com.cjbdevlabs.ingest;

import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

import java.io.InputStream;

public class FormData {

    @RestForm("file")
    public InputStream file;

    @RestForm("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    public String fileName;

    @RestForm("mimeType")
    @PartType(MediaType.TEXT_PLAIN)
    public String mimeType;
}
