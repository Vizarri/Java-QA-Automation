package tests;

import contains.Urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    protected RequestSpecification rspec;
    protected RequestSpecBuilder build;

    protected BaseTest() {
        build = new RequestSpecBuilder();
        build.setBaseUri(Urls.HTTPBIN_URL);
        rspec = build.build();
    }
}