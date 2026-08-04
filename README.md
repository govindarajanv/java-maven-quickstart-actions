|  Github Actions | SonarCloud | Hits | License |
|  :-------------: | :------: | :------------: | :------: |
| [![Java Service with Maven](https://github.com/govindarajanv/java-maven-quickstart-actions/actions/workflows/java-maven-api-develop.yml/badge.svg)](https://github.com/govindarajanv/java-maven-quickstart-actions/actions/workflows/java-maven-api-develop.yml) | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=govindarajanv_java-maven-quickstart-actions&metric=alert_status)](https://sonarcloud.io/dashboard?id=govindarajanv_java-maven-quickstart-actions) | [![HitCount](http://hits.dwyl.com/govindarajanv/java-maven-quickstart-actions.svg)](http://hits.dwyl.com/govindarajanv/java-maven-quickstart-actions) | [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) |


# Java Maven Quickstart Boiler Plate Repository

This quickstart boilerplate repository has a simple calculator web service implemented that caches the results of its computations, with endpoints in a format similar to the following:

- /addition/{a}/{b}/{c}
- /subtraction/{a}/{b}/{c}
- /multiplication/{a}/{b}/{c}
- /division/{a}/{b}

For the operations of addition, subtraction, and multiplication, the calculator endpoints should support an input of up to three numbers in the same call.

Each endpoint should support the GET method, and it should return the result in JSON format. If there is more than one call for the same operation on the same numbers, then the result should be returned from the cache rather than being recomputed.

## Links

- [Static Site for Documentation](https://govindarajanv.github.io/java-maven-quickstart-actions/)
- [SonarCloud Dashboard](https://sonarcloud.io/dashboard?id=govindarajanv_java-maven-quickstart-actions)
- [DockerHub](https://hub.docker.com/repository/docker/govindarajanv/java-maven-quickstart-service/tags?page=1&ordering=last_updated)
- [API](http://localhost:8080/addition/1/2/3)
- [CodeCov](https://app.codecov.io/gh/govindarajanv/java-maven-quickstart-actions/commits?page=1)
- [Marketplace](https://github.com/marketplace/actions/govind-secret-finder)
- [Pagerduty](https://govindarajanv.pagerduty.com/incidents)
- [Grafana](https://govindarajanv.grafana.net/dashboard/)

## References
- ltenconi/calculator-api
