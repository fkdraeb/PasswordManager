#!/bin/sh
cd PasswordManager-server
mvn clean install
docker build -t password-manager-image .
docker stop password-manager-container
docker run -p -d 8090:8090 --rm --name password-manager-container --network tfnet password-manager-image
