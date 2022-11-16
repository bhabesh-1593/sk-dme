import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the SalesOrderClinicalDetails entity.
 */
class SalesOrderClinicalDetailsGatlingTest extends Simulation {

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

    val scn = scenario("Test the SalesOrderClinicalDetails entity")
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
            exec(http("Get all salesOrderClinicalDetails")
            .get("/services/salesorder/api/sales-order-clinical-details")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new salesOrderClinicalDetails")
            .post("/services/salesorder/api/sales-order-clinical-details")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "salesOrderId":"0"
                , "patientId":"0"
                , "patientWeightInKg":"0"
                , "patientWeightInLbs":"0"
                , "heightInInches":"0"
                , "heightInCm":"0"
                , "salesRepId":"0"
                , "salesepName":"SAMPLE_TEXT"
                , "practitionerId":"0"
                , "renderingProviderType":"SAMPLE_TEXT"
                , "renderingProviderFacilityId":"0"
                , "renderingProviderFacilityName":"SAMPLE_TEXT"
                , "renderingProviderId":"0"
                , "renderingProviderFirstName":"SAMPLE_TEXT"
                , "renderingProviderMiddleName":"SAMPLE_TEXT"
                , "renderingProviderLastName":"SAMPLE_TEXT"
                , "renderingProviderNpi":"SAMPLE_TEXT"
                , "renderingProviderDea":"SAMPLE_TEXT"
                , "renderingProviderAddressId":"0"
                , "renderingProviderAddressLine1":"SAMPLE_TEXT"
                , "renderingProviderAddressLine2":"SAMPLE_TEXT"
                , "renderingProviderCityName":"SAMPLE_TEXT"
                , "renderingProviderStateName":"SAMPLE_TEXT"
                , "renderingProviderZip":"SAMPLE_TEXT"
                , "renderingProviderContactId":"0"
                , "renderingProviderPhone1":"SAMPLE_TEXT"
                , "renderingProviderPhone2":"SAMPLE_TEXT"
                , "renderingProviderEmail":"SAMPLE_TEXT"
                , "renderingProviderFax":"SAMPLE_TEXT"
                , "referringProviderType":"SAMPLE_TEXT"
                , "referringProviderFacilityId":"0"
                , "referringProviderFacilityName":"SAMPLE_TEXT"
                , "referringProviderId":"0"
                , "referringProviderFirstName":"SAMPLE_TEXT"
                , "referringProviderMiddleName":"SAMPLE_TEXT"
                , "referringProviderLastName":"SAMPLE_TEXT"
                , "referringProviderNpi":"SAMPLE_TEXT"
                , "referringProviderDea":"SAMPLE_TEXT"
                , "referringProviderAddressId":"0"
                , "referringProviderAddressLine1":"SAMPLE_TEXT"
                , "referringProviderAddressLine2":"SAMPLE_TEXT"
                , "referringProviderCityName":"SAMPLE_TEXT"
                , "referringProviderStateName":"SAMPLE_TEXT"
                , "referringProviderZip":"SAMPLE_TEXT"
                , "referringProviderContactId":"0"
                , "referringProviderPhone1":"SAMPLE_TEXT"
                , "referringProviderPhone2":"SAMPLE_TEXT"
                , "referringProviderEmail":"SAMPLE_TEXT"
                , "referringProviderFax":"SAMPLE_TEXT"
                , "orderingProviderType":"SAMPLE_TEXT"
                , "orderingProviderFacilityId":"0"
                , "orderingProviderFacilityName":"SAMPLE_TEXT"
                , "orderingProviderId":"0"
                , "orderingProviderFirstName":"SAMPLE_TEXT"
                , "orderingProviderMiddleName":"SAMPLE_TEXT"
                , "orderingProviderLastName":"SAMPLE_TEXT"
                , "orderingProviderNpi":"SAMPLE_TEXT"
                , "orderingProviderDea":"SAMPLE_TEXT"
                , "orderingProviderAddressId":"0"
                , "orderingProviderAddressLine1":"SAMPLE_TEXT"
                , "orderingProviderAddressLine2":"SAMPLE_TEXT"
                , "orderingProviderCityName":"SAMPLE_TEXT"
                , "orderingProviderStateName":"SAMPLE_TEXT"
                , "orderingProviderZip":"SAMPLE_TEXT"
                , "orderingProviderContactId":"0"
                , "orderingProviderPhone1":"SAMPLE_TEXT"
                , "orderingProviderPhone2":"SAMPLE_TEXT"
                , "orderingProviderEmail":"SAMPLE_TEXT"
                , "orderingProviderFax":"SAMPLE_TEXT"
                , "marketingReferalTypeId":"0"
                , "marketingReferalTypeDescription":"SAMPLE_TEXT"
                , "marketingReferalId":"0"
                , "marketingReferalName":"SAMPLE_TEXT"
                , "icd10DiagnosisCode1":"SAMPLE_TEXT"
                , "icd10DiagnosisCode2":"SAMPLE_TEXT"
                , "icd10DiagnosisCode3":"SAMPLE_TEXT"
                , "icd10DiagnosisCode4":"SAMPLE_TEXT"
                , "icd10DiagnosisCode5":"SAMPLE_TEXT"
                , "icd10DiagnosisCode6":"SAMPLE_TEXT"
                , "icd10DiagnosisCode7":"SAMPLE_TEXT"
                , "icd10DiagnosisCode8":"SAMPLE_TEXT"
                , "icd10DiagnosisCode9":"SAMPLE_TEXT"
                , "icd10DiagnosisCode10":"SAMPLE_TEXT"
                , "icd10DiagnosisCode11":"SAMPLE_TEXT"
                , "icd10DiagnosisCode12":"SAMPLE_TEXT"
                , "epsdtCertificationConditionIndicator":"SAMPLE_TEXT"
                , "epsdtCertificationCode":"SAMPLE_TEXT"
                , "status":"SAMPLE_TEXT"
                , "createdById":"0"
                , "createdByName":"SAMPLE_TEXT"
                , "createdDate":"2020-01-01T00:00:00.000Z"
                , "updatedById":"0"
                , "updatedByName":"SAMPLE_TEXT"
                , "updatedDate":"2020-01-01T00:00:00.000Z"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_salesOrderClinicalDetails_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created salesOrderClinicalDetails")
                .get("/services/salesorder${new_salesOrderClinicalDetails_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created salesOrderClinicalDetails")
            .delete("/services/salesorder${new_salesOrderClinicalDetails_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
