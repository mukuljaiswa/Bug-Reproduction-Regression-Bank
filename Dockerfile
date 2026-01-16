# Use Maven with OpenJDK 11 as the base image
FROM maven:3.8.6-openjdk-11

# Set the working directory inside the container
WORKDIR /app

# Install Google Chrome (stable)
RUN apt-get update && apt-get install -y wget gnupg2 \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list' \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Copy project definition
COPY pom.xml .

# Pre-download dependencies to improve build speed on subsequent changes
# We use 'clean install' with skip tests to ensure everything is downloaded
RUN mvn clean install -DskipTests

# Copy the rest of the application source code
COPY src ./src
COPY testng.xml .
COPY testng_api.xml .

# Set environment variable to switch BaseTest to headless mode (Default)
# To run with UI, use the run_ui_tests.sh script or pass -e HEADLESS=false
ENV HEADLESS=true

# Default command to run the regression suite
# You can override this to run API tests: docker run <image> mvn test -DsuiteXmlFile=testng_api.xml
CMD ["mvn", "test"]
