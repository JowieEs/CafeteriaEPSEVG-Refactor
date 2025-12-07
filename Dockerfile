FROM ubuntu:latest
LABEL authors="joel"

ENTRYPOINT ["top", "-b"]