package com.cjbdevlabs.ingest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@JBossLog
@Path("/ingest")
public class IngestResource {

    @ConfigProperty(name = "ingest.bucket.name")
    String bucketName;

    @Inject
    S3Client s3Client;

    @Path("s3")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(FormData formData) {
        try {
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(formData.fileName)
                            .contentType(formData.mimeType != null ? formData.mimeType : "application/octet-stream")
                            .build(),
                    RequestBody.fromInputStream(formData.file, formData.file.available())
            );
            return Response.ok("{\"message\":\"File successfully uploaded to S3\"}").build();
        } catch (Exception e) {
            log.errorf("Error uploading file: %s", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Failed to upload file to S3\"}")
                    .build();
        }
    }
}
