package com.regression.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    protected static final String RPC_URL = "https://rpc.awakening.bdagscan.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = RPC_URL;
    }
}
