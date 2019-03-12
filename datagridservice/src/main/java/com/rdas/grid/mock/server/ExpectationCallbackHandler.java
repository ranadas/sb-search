package com.rdas.grid.mock.server;

import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.Times;

import static org.mockserver.model.Cookie.cookie;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

public class ExpectationCallbackHandler {

    public void respondDifferentlyForTheSameRequest() {
        MockServerClient mockServerClient = new MockServerClient("localhost", 1080);

        // respond once with 200, then respond twice with 204, then
        // respond with 404 as no remaining active expectations
        mockServerClient
                .when(
                        request()
                                .withPath("/some/path"),
                        Times.exactly(1)
                )
                .respond(
                        response()
                                .withStatusCode(200)
                );

        mockServerClient
                .when(
                        request()
                                .withPath("/some/path"),
                        Times.exactly(2)
                )
                .respond(
                        response()
                                .withStatusCode(204)
                );
    }

    public void createExpectationMockServerClient() {
        new MockServerClient("localhost", 1080)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/view/cart")
                                .withCookies(
                                        cookie("session", "4930456C-C718-476F-971F-CB8E047AB349")
                                )
                                .withQueryStringParameters(
                                        param("cartId", "055CA455-1DF7-45BB-8535-4F83E7266092")
                                )
                )
                .respond(
                        response()
                                .withBody("some_response_body")
                );
    }

    public void responseLiteralWithBodyOnly() {
        new MockServerClient("localhost", 1080)
                // this request matcher matches every request
                .when(
                        request()
                )
                .respond(
                        response()
                                .withBody("some_response_body")
                );
    }
}
