# BlockDAG Automation - Docker Instructions

This project includes a Dockerfile to run the automation tests in a containerized environment with Chrome and Maven pre-installed.

## Prerequisites

- Docker installed on your machine.

## Building the Image

Build the Docker image using the following command:

```bash
docker build -t bdag-auto .
```

## Running Tests

### Run the Default UI Regression Suite

The default command runs `mvn test`, which executes your `testng.xml` suite (UI tests).

```bash
docker run --rm bdag-auto
```

### Run API Tests

To run the API test suite created in `testng_api.xml`:

```bash
docker run --rm bdag-auto mvn test -DsuiteXmlFile=testng_api.xml
```

### Run Specific Tests

You can run individual test classes using Maven properties:

```bash
docker run --rm bdag-auto mvn test -Dtest=Bdag_Rpc_Tests
```

## Troubleshooting

- **Headless Mode**: The container acts as a headless environment. The `HEADLESS=true` environment variable is set automatically in the Dockerfile, which `BaseTest.java` uses to configure Chrome Options.
- **Shared Memory**: If you encounter crashes related to shared memory, add the `--shm-size=2g` flag to your `docker run` command:
  ```bash
  docker run --rm --shm-size=2g bdag-auto
  ```

## Viewing the Browser (GUI Mode)

By default, the Docker container runs in **Headless Mode** (no visible browser), which is standard for containerized environments.

If you are on **Linux** and want to see the browser running inside the container, you can use X11 forwarding:

1. Allow access to your X server:
   ```bash
   xhost +local:docker
   ```

2. Run the container with the `DISPLAY` environment variable and `HEADLESS=false`:
   ```bash
   docker run -it --rm \
     --net=host \
     --env="DISPLAY" \
     --env="HEADLESS=false" \
     --volume="$HOME/.Xauthority:/root/.Xauthority:rw" \
     bdag-auto
   ```

*Note: This requires an X11 server running on your host machine.*
