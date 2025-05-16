#!/bin/bash
./gradlew clean build -x test
docker buildx build --platform linux/amd64 --load --tag sangbam/sopkathon:0.0.1 .
docker push sangbam/sopkathon:0.0.1