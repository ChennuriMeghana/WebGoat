rules:
  - id: cookie-httponly-false
    message: A cookie was detected without setting the 'HttpOnly' flag. The
      'HttpOnly' flag for cookies instructs the browser to forbid client-side
      scripts from reading the cookie. Set the 'HttpOnly' flag by calling
      'cookie.setHttpOnly(true);'
    severity: WARNING
    metadata:
      likelihood: LOW
      impact: LOW
      confidence: HIGH
      category: security
      subcategory:
        - audit
      asvs:
        section: "V3: Session Management Verification Requirements"
        control_id: 3.4.2 Missing Cookie Attribute
        control_url: https://github.com/OWASP/ASVS/blob/master/4.0/en/0x12-V3-Session-management.md#v34-cookie-based-session-management
        version: "4"
      cwe:
        - "CWE-1004: Sensitive Cookie Without 'HttpOnly' Flag"
      functional-categories:
        - web::search::cookie-config
      owasp:
        - A05:2021 - Security Misconfiguration
      references:
        - https://owasp.org/www-community/HttpOnly
      source-rule-url: https://find-sec-bugs.github.io/bugs.htm#HTTPONLY_COOKIE
      technology:
        - java
        - servlets
      license: Copyright 2023 Semgrep, Inc.
      vulnerability_class:
        - Cookie Security
    languages:
      - java
    fix: |
      $COOKIE.setHttpOnly(true);
    pattern: |
      $COOKIE.setHttpOnly(false);
