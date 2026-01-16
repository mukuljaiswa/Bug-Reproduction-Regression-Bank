#!/bin/bash

# Allow docker to access the local X server (Linux only)
xhost +local:docker

# Run the container with X11 forwarding enabled
# We mount the Xauthority and pass the DISPLAY env var
docker run -it --rm \
  --net=host \
  --env="DISPLAY" \
  --env="HEADLESS=false" \
  --volume="$HOME/.Xauthority:/root/.Xauthority:rw" \
  bdag-ui:latest
