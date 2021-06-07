# Java Maven Quickstart Boiler Plate Repository

This quickstart boilerplate repository has a simple calculator web service implemented that caches the results of its computations, with endpoints in a format similar to the followingggg:

- /addition/{a}/{b}/{c}/{d}
- /subtraction/{a}/{b}/{c}
- /multiplication/{a}/{b}/{c}
- /division/{a}/{b}

For the operations of addition, subtraction, and multiplication, the calculator endpoints should support an input of up to three numbers in the same call.

Each endpoint should support the GET method, and it should return the result in JSON format. If there is more than one call for the same operation on the same numbers, then the result should be returned from the cache rather than being recomputed.

### Note: This static site will be implemented using jekyll or mkdocs


## Links

- [Static Site for Documentation](https://govindarajanv.github.io/java-maven-quickstart-actions/)
- [SonarCloud Dashboard](https://sonarcloud.io/dashboard?id=govindarajanv_java-maven-quickstart-actions)
- [DockerHub](https://hub.docker.com/repository/docker/govindarajanv/java-maven-quickstart-service/tags?page=1&ordering=last_updated)
- [Heroku Dashboard](https://dashboard.heroku.com/apps/java-maven-quickstart-service/activity)
- [API](https://java-maven-quickstart-service.herokuapp.com/addition/1/2/3)
- [CodeCov](https://app.codecov.io/gh/govindarajanv/java-maven-quickstart-actions/commits?page=1)

