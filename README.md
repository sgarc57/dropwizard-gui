#dropwizard boilerplate
This project serves as boilerplate for a docker image deployable to kubernetes

# dropwizard-gui
Example project using vue.js static content and dropwizard

## Static Assets
Compile and run the application. Go to following URLs for static assets.

#docker
docker run -p 8080:8080 `docker build . | tail -1 | cut -d' ' -f3`


http://localhost:8080/index.html
