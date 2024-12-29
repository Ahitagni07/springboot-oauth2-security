# springboot-oauth2-security

Springboot project with Google oauth2 security

1. **Configure Google OAuth2 Authorization Flow to obtain the access token.**

   To authorize your API using a token from Google's OAuth2 server, follow these steps:

    Step 1.1: Create Google OAuth2 Credentials
    Go to the Google Developer Console.
    Create a new project or use an existing project.
    Under APIs & Services, go to Credentials.
    Create OAuth 2.0 Client IDs for your application. Choose Web application and add authorized redirect URIs for your local setup (e.g., http://localhost:8080/login/oauth2/code/google).
    Obtain your Client ID and Client Secret from this section.
    Step 1.2: Configure Google OAuth2 in Postman
    Open Postman and create a new Request.
    
    In the Authorization tab, select OAuth 2.0 as the type.
    
    Click on Get New Access Token and fill in the following details:
    
    Token Name: Google OAuth2 Token
    Grant Type: Authorization Code
    Callback URL: (Use your redirect URI, e.g., http://localhost:8080/login/oauth2/code/google)
    Auth URL: https://accounts.google.com/o/oauth2/v2/auth
    Access Token URL: https://oauth2.googleapis.com/token
    Client ID: Your Google Client ID
    Client Secret: Your Google Client Secret
    Scope: email profile (or any other scopes you need)
    State: (Optional, for security)
    After filling in these details, click Request Token. Google will open a browser window where you will be prompted to grant access to your Google account. Upon successful login, you’ll get the access token.
    
    Once you get the access token in Postman, click Use Token to use it in your requests.


2. **Set Up Spring Boot to Validate Google Bearer Tokens**

   Spring Boot application needs to act as a Resource Server that validates the Bearer token issued by Google. This is done by configuring Spring Security to validate the OAuth2 tokens.

    Step 2.1: Add Dependencies for Resource Server
    In your pom.xml, add the necessary dependencies:
    

    <dependencies>
        <!-- Spring Boot Web Dependency -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    
        <!-- Spring Security Dependency -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
    
        <!-- Spring Security OAuth2 Resource Server for validating tokens -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
        </dependency>
    
        <!-- JWT Support for OAuth2 (optional if you use JWTs as Bearer tokens) -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-oauth2-jose</artifactId>
        </dependency>
    </dependencies>
    
