Starting udemy microservices course,
will keep on adding projects and codes based on
my progress with the course

commands
To start the ms containers using docker compose file, goto
the docker compose file directory and run:
$ docker compose up -d

The kill and delete the containers that were created by docker compose
$ docker compose down

To just stop the container and not delete we can use"
$ docker compose stop

but its advisable to delete the containers

To start present container:
$ docker compose start

docker commands
docker images
docker image inspect[image-id]
docker image rm [image-id]
docker build . -t[image-name]
docker run -p[hostport]:[containerport][image_name]
docker ps
docker ps -a
docker container start [container-id]
docker container pause [container-id]
docker container unpause [container-id]
docker container stop [container-id]
docker container kill [container-id]
docker container restart [container-id]
docker container inspect [container-id]
docker container logs [container-id]

docker container logs -f [container-id]
docker rm [container-id]
docker container prune
docker image push [container_registry/username:tag]
docker image pull [container_registry/username:tag]
docker image prune
docker container stats
docker system prune
docker rmi[image-id]
docker login -u [username]
docker logout
docker history [image-name]
docker exec -it[container-id] sh
docker compose up
docker compose down


