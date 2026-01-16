package com.cjbdevlabs.ingest;

import org.jboss.resteasy.reactive.RestForm;

import java.io.InputStream;

public record FormData(
        @RestForm("file") InputStream file,
        @RestForm("filename") String filename,
        @RestForm("mimeType") String mimeType
) {}
