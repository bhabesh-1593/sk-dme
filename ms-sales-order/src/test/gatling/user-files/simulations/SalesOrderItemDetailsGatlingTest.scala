import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the SalesOrderItemDetails entity.
 */
class SalesOrderItemDetailsGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8081"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results
        .disableFollowRedirect // We must follow redirects manually to get the xsrf token from the keycloak redirect
        .disableAutoReferer

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "X-XSRF-TOKEN" -> "${xsrf_token}"
    )

    val keycloakHeaders = Map(
        "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Upgrade-Insecure-Requests" -> "1"
    )

    val scn = scenario("Test the SalesOrderItemDetails entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(302))
        .check(headerRegex("Set-Cookie", "XSRF-TOKEN=(.*);[\\s]").saveAs("xsrf_token"))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .get("/oauth2/authorization/oidc")
        .check(status.is(302))
        .check(header("Location").saveAs("loginUrl"))).exitHereIfFailed
        .pause(2)
        .exec(http("Login Redirect")
        .get("${loginUrl}")
        .silent
        .headers(keycloakHeaders)
        .check(css("#kc-form-login", "action").saveAs("kc-form-login"))).exitHereIfFailed
        .pause(10)
        .exec(http("Authenticate")
        .post("${kc-form-login}")
        .silent
        .headers(keycloakHeaders)
        .formParam("username", "admin")
        .formParam("password", "admin")
        .formParam("submit", "Login")
        .check(status.is(302))
        .check(header("Location").saveAs("afterLoginUrl"))).exitHereIfFailed
        .pause(2)
        .exec(http("After Login Redirect")
        .get("${afterLoginUrl}")
        .silent
        .check(status.is(302))
        .check(header("Location").saveAs("finalRedirectUrl"))
        .check(headerRegex("Set-Cookie", "XSRF-TOKEN=(.*);[\\s]").saveAs("xsrf_token")))
        .exec(http("Final Redirect")
        .get("${finalRedirectUrl}")
        .silent
        .check(status.is(200))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all salesOrderItemDetails")
            .get("/services/salesorder/api/sales-order-item-details")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new salesOrderItemDetails")
            .post("/services/salesorder/api/sales-order-item-details")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "salesOrderItemDetailsId":"0"
                , "salesOrderId":"0"
                , "patientId":"0"
                , "itemLocationId":"0"
                , "salesOrderDetailItemId":"0"
                , "salesOrderDetailItemName":"SAMPLE_TEXT"
                , "salesOrderDetailStockingUom":"SAMPLE_TEXT"
                , "salesOrderDetailStockingUomName":"SAMPLE_TEXT"
                , "salesOrderDetailItemDescription":"SAMPLE_TEXT"
                , "salesOrderDetailDefaultVendor":"SAMPLE_TEXT"
                , "salesOrderDetailOriginalDos":"2020-01-01T00:00:00.000Z"
                , "salesOrderDetailPreviousBillingDate":"2020-01-01T00:00:00.000Z"
                , "salesOrderDetailNextBillingDate":"2020-01-01T00:00:00.000Z"
                , "salesOrderDetailDosTo":"2020-01-01T00:00:00.000Z"
                , "salesOrderDetailNextPeriod":"SAMPLE_TEXT"
                , "salesOrderDetailSpecialPricing":"SAMPLE_TEXT"
                , "salesOrderDetailPriceOverride":"SAMPLE_TEXT"
                , "salesOrderDetailSpecialTaxRate":"0"
                , "salesOrderDetailQty":"0"
                , "salesOrderDetailBqty":"0"
                , "salesOrderDetailLineQty":"0"
                , "salesOrderDetailProcCode":"SAMPLE_TEXT"
                , "salesOrderDetailPriceOption":"SAMPLE_TEXT"
                , "salesOrderDetailModifier1":"SAMPLE_TEXT"
                , "salesOrderDetailModifier2":"SAMPLE_TEXT"
                , "salesOrderDetailModifier3":"SAMPLE_TEXT"
                , "salesOrderDetailModifier4":"SAMPLE_TEXT"
                , "salesOrderDetailChargeAmt":"0"
                , "salesOrderDetailAllowedAmt":"0"
                , "salesOrderDetailTaxable":"SAMPLE_TEXT"
                , "salesOrderDetailAbn":"SAMPLE_TEXT"
                , "salesOrderDetailAbnUpgrade":"SAMPLE_TEXT"
                , "salesOrderDetailAbnPrintDate":"2020-01-01T00:00:00.000Z"
                , "salesOrderDetailAbnItem":"SAMPLE_TEXT"
                , "salesOrderDetailAbnProcCode":"SAMPLE_TEXT"
                , "salesOrderDetailAbnAllow":"SAMPLE_TEXT"
                , "salesOrderDetailAbnCharge":"0"
                , "salesOrderDetailAbnModifier1":"SAMPLE_TEXT"
                , "salesOrderDetailAbnModifier2":"SAMPLE_TEXT"
                , "salesOrderDetailTaxRate":"0"
                , "salesOrderDetailTaxZone":"SAMPLE_TEXT"
                , "salesOrderDetailNonTaxReason":"SAMPLE_TEXT"
                , "salesOrderDetailNote":"SAMPLE_TEXT"
                , "salesOrderDetailSaleType":"SAMPLE_TEXT"
                , "salesOrderDetailItemGroup":"SAMPLE_TEXT"
                , "salesOrderDetailItemUser1":"SAMPLE_TEXT"
                , "salesOrderDetailItemUser2":"SAMPLE_TEXT"
                , "salesOrderDetailItemUser3":"SAMPLE_TEXT"
                , "salesOrderDetailItemUser4":"SAMPLE_TEXT"
                , "salesOrderDetailConvertedToPurchase":"SAMPLE_TEXT"
                , "salesOrderDetailManualConvertToPurchaseMctp":"SAMPLE_TEXT"
                , "salesOrderDetailMctpChargeAmt":"0"
                , "salesOrderDetailMctpAllowedAmt":"0"
                , "salesOrderDetailMctpModifier1":"SAMPLE_TEXT"
                , "salesOrderDetailMctpModifier2":"SAMPLE_TEXT"
                , "salesOrderDetailMctpModifier3":"SAMPLE_TEXT"
                , "salesOrderDetailMctpModifier4":"SAMPLE_TEXT"
                , "salesOrderDetailMctpPeriod":"0"
                , "salesOrderDetailAddtlModifier1":"SAMPLE_TEXT"
                , "salesOrderDetailAddtlModifier2":"SAMPLE_TEXT"
                , "salesOrderDetailAddtlModifier3":"SAMPLE_TEXT"
                , "salesOrderDetailAddtlModifier4":"SAMPLE_TEXT"
                , "salesOrderDetailNextDateOfService":"2020-01-01T00:00:00.000Z"
                , "salesOrderDetailPriceTable":"SAMPLE_TEXT"
                , "salesOrderDetailPriceOptionName":"SAMPLE_TEXT"
                , "salesOrderDetailExtendedChargeAmount":"0"
                , "salesOrderDetailExtendedAllowanceAmount":"0"
                , "salesOrderDetailItemNdcCode":"SAMPLE_TEXT"
                , "salesOrderDetailManufacturer":"SAMPLE_TEXT"
                , "salesOrderDetailCbPricing":"SAMPLE_TEXT"
                , "salesOrderDetailCbPriceTableOverride":"SAMPLE_TEXT"
                , "salesOrderDetailCbOverride":"SAMPLE_TEXT"
                , "salesOrderDetailMessages":"SAMPLE_TEXT"
                , "salesOrderDetailLocation":"0"
                , "salesOrderDetailCaloriesPerDay":"0"
                , "salesOrderDetailSecondaryBillingProcudureCode":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingPriceOption":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingPriceOptionName":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingModifier1":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingModifier2":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingModifier3":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingModifier4":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingAdditionalModifier1":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingadditionalModifier2":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingadditionalModifier3":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingadditionalModifier4":"SAMPLE_TEXT"
                , "salesOrderDetailSecondaryBillingIgnore":"SAMPLE_TEXT"
                , "salesOrderDetailSecondarySpecialBilling":"SAMPLE_TEXT"
                , "salesOrderDetailSpanDateSplitBilling":"SAMPLE_TEXT"
                , "salesOrderDetailManufacturerItemIdNumber":"SAMPLE_TEXT"
                , "cmnId":"0"
                , "cmnparCmnFormId":"0"
                , "cmnparCmnKey":"SAMPLE_TEXT"
                , "cmnparCmnCreateDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnExpirationDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnInitialDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnRenewalDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnRecertificationDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnPhysicianDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnStatus":"SAMPLE_TEXT"
                , "cmnparParId":"0"
                , "cmnparParDescr":"SAMPLE_TEXT"
                , "cmnparParInitialDate":"2020-01-01T00:00:00.000Z"
                , "cmnparParExpirationDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnLogDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnLengthOfNeed":"0"
                , "cmnparCmnPrintedDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnPrintedBy":"SAMPLE_TEXT"
                , "cmnparFaxedDate":"2020-01-01T00:00:00.000Z"
                , "cmnparCmnPlaceholder":"SAMPLE_TEXT"
                , "cmnparCmnFaxedBy":"SAMPLE_TEXT"
                , "cmnparCmnLoggedBy":"SAMPLE_TEXT"
                , "cmnparNumberOfRefills":"0"
                , "status":"SAMPLE_TEXT"
                , "createdById":"0"
                , "createdByName":"SAMPLE_TEXT"
                , "createdDate":"2020-01-01T00:00:00.000Z"
                , "updatedById":"0"
                , "updatedByName":"SAMPLE_TEXT"
                , "updatedDate":"2020-01-01T00:00:00.000Z"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_salesOrderItemDetails_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created salesOrderItemDetails")
                .get("/services/salesorder${new_salesOrderItemDetails_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created salesOrderItemDetails")
            .delete("/services/salesorder${new_salesOrderItemDetails_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
