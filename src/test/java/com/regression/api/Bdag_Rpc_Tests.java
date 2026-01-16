package com.regression.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Bdag_Rpc_Tests extends BaseApiTest {

    @Test(description = "Verify eth_blockNumber returns a hex result")
    public void testEthBlockNumber() {
        String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_blockNumber\",\"params\":[],\"id\":1}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("result", notNullValue())
                .body("result", startsWith("0x"))
                .body("id", equalTo(1));
    }

    @Test(description = "Verify eth_chainId returns 1043 (0x413)")
    public void testEthChainId() {
        String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_chainId\",\"params\":[],\"id\":2}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("result", equalTo("0x413")) // 1043 in hex
                .body("id", equalTo(2));
    }

    @Test(description = "Verify net_version returns 1043")
    public void testNetVersion() {
        String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"net_version\",\"params\":[],\"id\":3}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("result", equalTo("1043"))
                .body("id", equalTo(3));
    }

    @Test(description = "Verify eth_gasPrice returns a value")
    public void testEthGasPrice() {
        String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_gasPrice\",\"params\":[],\"id\":4}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("result", startsWith("0x"))
                .body("id", equalTo(4));
    }

    @Test(description = "Verify web3_clientVersion returns version string")
    public void testWeb3ClientVersion() {
        String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"web3_clientVersion\",\"params\":[],\"id\":5}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("result", notNullValue())
                .body("id", equalTo(5));
    }

    @Test(description = "Verify details for a nonexistent block return null")
    public void testEthGetBlockByNumber_FutureBlock() {
        // Requesting a very high block number that likely doesn't exist
        String requestBody = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_getBlockByNumber\",\"params\":[\"0x99999999\", false],\"id\":6}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("result", nullValue())
                .body("id", equalTo(6));
    }
}
