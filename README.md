# E2E Automation Framework — SauceDemo

[![CI Pipeline](https://github.com/Pramodini-2021/E2E-Automation-Framework/actions/workflows/ci.yml/badge.svg)](https://github.com/Pramodini-2021/E2E-Automation-Framework/actions/workflows/ci.yml)

A Selenium + Java + TestNG test automation framework built using the Page Object Model, with CI/CD integration via GitHub Actions and automated HTML reporting via Extent Reports. Tests run against [SauceDemo](https://www.saucedemo.com), covering login, cart, and checkout flows end-to-end.

## Tech Stack

| Category | Tool |
|---|---|
| Language | Java 18 |
| Test Framework | TestNG |
| Browser Automation | Selenium WebDriver 4 |
| Build Tool | Maven |
| Driver Management | WebDriverManager |
| Reporting | Extent Reports |
| CI/CD | GitHub Actions |

## Framework Architecture

**Page Object Model (POM)** — Each page of the application (Login, Products, Cart, Checkout) has its own class holding locators and actions. Tests interact with these page objects instead of raw Selenium calls, so UI changes only require updates in one place, not across every test.

**Explicit waits over implicit waits** — Rather than fixed sleep timers, the framework uses `WebDriverWait` to wait for specific conditions (visibility, clickability) before interacting with elements. This makes tests resilient to variable page load times, especially in CI environments.

**JavaScript-based interaction fallback** — While debugging CI reliability, native Selenium clicks and `sendKeys()` were found to silently fail in headless Chrome against certain elements (icon-based buttons, React-controlled inputs). The framework includes `jsClick()` and `jsType()` utilities that interact with the DOM directly via JavaScript, correctly triggering React's synthetic event system where needed.

**Config-driven execution** — Browser, base URL, and timeout values are externalized in `config.properties`, avoiding hardcoded values and supporting easy environment switching.

**Headless CI execution** — Chrome runs headless with an explicit window size when executed in GitHub Actions, since headless mode doesn't support `--start-maximized`. Locally, tests run in a normal visible browser window.


## Project Structure

```
E2E-Automation-Framework/
├── src/
│   ├── main/java/
│   │   ├── pages/
│   │   ├── utils/
│   │   └── config/
│   └── test/java/
│       ├── tests/
│       └── listeners/
├── .github/workflows/
│   └── ci.yml
├── pom.xml
└── README.md
```

## How to Run Locally

**Prerequisites:** Java 18+, Maven, Google Chrome

```bash
git clone https://github.com/Pramodini-2021/E2E-Automation-Framework.git
cd E2E-Automation-Framework
mvn clean test
```

Test results are generated at `test-output/ExtentReport.html` — open this file in a browser to view the pass/fail dashboard.

## CI/CD

Every push to `main` automatically triggers the test suite on GitHub Actions, running on a clean Ubuntu environment with headless Chrome. Test reports and screenshots are uploaded as workflow artifacts for review.

## Test Coverage

- Valid and invalid login scenarios
- Add-to-cart and cart badge verification
- Full end-to-end checkout flow (login → cart → checkout → order confirmation)
