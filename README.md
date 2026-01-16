# ingest-service

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
mvn quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:9090/q/dev/>.

## Test Curl Command

```shell script
curl -X POST http://localhost:9090/ingest/s3 \
  -H "Content-Type: multipart/form-data" \
  -F "file=@./src/test/resources/test.json" \
  -F "filename=test.json" \
  -F "mimeType=application/json"
```

## Related Guides

- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus
  REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Amazon S3 ([guide](https://docs.quarkiverse.io/quarkus-amazon-services/dev/amazon-s3.html)): Connect to Amazon S3
  cloud storage
