import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the SalesOrderInsuranceDetails entity.
 */
class SalesOrderInsuranceDetailsGatlingTest extends Simulation {

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

    val scn = scenario("Test the SalesOrderInsuranceDetails entity")
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
            exec(http("Get all salesOrderInsuranceDetails")
            .get("/services/salesorder/api/sales-order-insurance-details")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new salesOrderInsuranceDetails")
            .post("/services/salesorder/api/sales-order-insurance-details")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "salesOrderInsuranceDetailsId":"0"
                , "salesOrderId":"0"
                , "patientId":"0"
                , "primaryInsurerId":"0"
                , "primaryInsurerName":"SAMPLE_TEXT"
                , "primaryInsuranceGroupId":"0"
                , "primaryInsuranceGroupName":"SAMPLE_TEXT"
                , "primaryInsurancePlanId":"0"
                , "primaryInsurancePlanType":"SAMPLE_TEXT"
                , "primaryInsuranceStateId":"0"
                , "primaryInsuranceStateName":"SAMPLE_TEXT"
                , "primaryInsurerPolicyNo":"SAMPLE_TEXT"
                , "primaryInsurerPatientIdNumber":"SAMPLE_TEXT"
                , "primaryInsurerEffectiveDate":"2020-01-01T00:00:00.000Z"
                , "primaryInsurerVerificationStatus":"SAMPLE_TEXT"
                , "primaryInsurerVerificationDate":"2020-01-01T00:00:00.000Z"
                , "primaryInsurerPayPercentage":"0"
                , "primaryBox10d":"SAMPLE_TEXT"
                , "primaryBox19":"SAMPLE_TEXT"
                , "primaryBox24ia":"SAMPLE_TEXT"
                , "primaryBox24ja":"SAMPLE_TEXT"
                , "primaryBox24jb":"SAMPLE_TEXT"
                , "primaryIncludeBox24Jbstatus":"SAMPLE_TEXT"
                , "primaryIncludePayerSalesOrderStatus":"SAMPLE_TEXT"
                , "primaryWaitForPreviousPayerBeforeBillingStatus":"SAMPLE_TEXT"
                , "primaryPayPercentageStatus":"SAMPLE_TEXT"
                , "secondaryInsurerId":"0"
                , "secondaryInsurerName":"SAMPLE_TEXT"
                , "secondaryInsuranceGroupId":"0"
                , "secondaryInsuranceGroupName":"SAMPLE_TEXT"
                , "secondaryInsurancePlanId":"0"
                , "secondaryInsurancePlanType":"SAMPLE_TEXT"
                , "secondaryInsuranceStateId":"0"
                , "secondaryInsuranceStateName":"SAMPLE_TEXT"
                , "secondaryInsurerPolicyNo":"SAMPLE_TEXT"
                , "secondaryInsurerPatientIdNumber":"SAMPLE_TEXT"
                , "secondaryInsurerEffectiveDate":"2020-01-01T00:00:00.000Z"
                , "secondaryInsurerVerificationStatus":"SAMPLE_TEXT"
                , "secondaryInsurerVerificationDate":"2020-01-01T00:00:00.000Z"
                , "secondaryInsurerPayPercentage":"0"
                , "secondaryBox10d":"SAMPLE_TEXT"
                , "secondaryBox19":"SAMPLE_TEXT"
                , "secondaryBox24ia":"SAMPLE_TEXT"
                , "secondaryBox24ja":"SAMPLE_TEXT"
                , "secondaryBox24jb":"SAMPLE_TEXT"
                , "secondaryIncludeBox24jbStatus":"SAMPLE_TEXT"
                , "secondaryIncludePayerSalesOrderStatus":"SAMPLE_TEXT"
                , "secondaryWaitPreviousPayerBefrBillingStatus":"SAMPLE_TEXT"
                , "secondaryPayPercentageStatus":"SAMPLE_TEXT"
                , "tertiaryInsurerId":"0"
                , "tertiaryInsurerName":"SAMPLE_TEXT"
                , "tertiaryInsuranceGroupId":"0"
                , "tertiaryInsuranceGroupName":"SAMPLE_TEXT"
                , "tertiaryInsurancePlanId":"0"
                , "tertiaryInsurancePlanType":"SAMPLE_TEXT"
                , "tertiaryInsuranceStateId":"0"
                , "tertiaryInsuranceStateName":"SAMPLE_TEXT"
                , "tertiaryInsurerPolicyno":"SAMPLE_TEXT"
                , "tertiaryInsurerPatientIdNumber":"SAMPLE_TEXT"
                , "tertiaryInsurerEffectiveDate":"2020-01-01T00:00:00.000Z"
                , "tertiaryInsurerVerificationStatus":"SAMPLE_TEXT"
                , "tertiaryInsurerVerificationDate":"2020-01-01T00:00:00.000Z"
                , "tertiaryInsurerPayPercentage":"0"
                , "tertiaryBox10d":"SAMPLE_TEXT"
                , "tertiaryBox19":"SAMPLE_TEXT"
                , "tertiaryBox24ia":"SAMPLE_TEXT"
                , "tertiaryBox24ja":"SAMPLE_TEXT"
                , "tertiaryBox24jb":"SAMPLE_TEXT"
                , "tertiaryIncludeBox24jbStatus":"SAMPLE_TEXT"
                , "tertiaryIncludePayerInSalesOrderStatus":"SAMPLE_TEXT"
                , "tertiaryWaitPreviousPayerBeforeBillingStatus":"SAMPLE_TEXT"
                , "tertiaryPayPercentage0Status":"SAMPLE_TEXT"
                , "insuranceVerificationStatus":"SAMPLE_TEXT"
                , "coverageVerificationStatus":"SAMPLE_TEXT"
                , "excludeFromEligibilityCheckStatus":"SAMPLE_TEXT"
                , "patientPayPercentage":"SAMPLE_TEXT"
                , "patientIncludeThisPayorInSalesOrderStatus":"SAMPLE_TEXT"
                , "patientWaitForPreviousPayerBeforeBillingStatus":"SAMPLE_TEXT"
                , "workersCompDateOfOnset":"2020-01-01T00:00:00.000Z"
                , "workersCompInjuryRelatedEmploymentStatus":"SAMPLE_TEXT"
                , "workersCompInjuryRelatedAutoAccidentStatus":"SAMPLE_TEXT"
                , "workersCompAutoAccidentStateId":"0"
                , "workersCompInjuryRelatedToOtherAccidentStatus":"SAMPLE_TEXT"
                , "eclaimsAttachmentStatus":"SAMPLE_TEXT"
                , "attachmentNumber":"0"
                , "typeCode":"SAMPLE_TEXT"
                , "transactionCode":"SAMPLE_TEXT"
                , "claimsNoteType":"SAMPLE_TEXT"
                , "claimsNote":"SAMPLE_TEXT"
                , "salesOrderNo":"SAMPLE_TEXT"
                , "status":"SAMPLE_TEXT"
                , "createdById":"0"
                , "createdByName":"SAMPLE_TEXT"
                , "createdDate":"2020-01-01T00:00:00.000Z"
                , "updatedById":"0"
                , "updatedByName":"SAMPLE_TEXT"
                , "updatedDate":"2020-01-01T00:00:00.000Z"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_salesOrderInsuranceDetails_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created salesOrderInsuranceDetails")
                .get("/services/salesorder${new_salesOrderInsuranceDetails_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created salesOrderInsuranceDetails")
            .delete("/services/salesorder${new_salesOrderInsuranceDetails_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
