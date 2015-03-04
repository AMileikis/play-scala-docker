This project consists of 2 parts. A Dockerfile which will build a Docker image based on Ubuntu 14.04 and installing java, sbt (scala) and git.
The Dockerfile will then re-clone this project, build, unzip and deploy the application my-app. This is a simple Scala Play framework application pinging "You have successfully run the docker image in a container" to port 9217.


Prerequisites:
- User should be running Ubuntu.
- User must have Docker installed. (sudo apt-get install docker.io)

To build the image:

sudo docker build -t image_name:tag .

To see the list of images:

sudo docker images

To run this image in a container:

sudo docker run -i -t -p 9217:9217 image_name:tag

To see the list of running containers, with their images:

sudo docker ps -a

When the image runs successfully, go to: localhost:9217
