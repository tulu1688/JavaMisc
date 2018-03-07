# How to install prometheus
- Download release version at [Prometheus download site](https://prometheus.io/download/)
- Get prometheus docker
    - Start prometheus docker with sample configuration
    ```
    docker run -p 9090:9090 prom/prometheus
    ```
    - Bind-mount your prometheus.yml from the host by running:
    ```
    docker run -p 9090:9090 -v /tmp/prometheus.yml:/etc/prometheus/prometheus.yml \
        prom/prometheus
    ```
- Run custom prometheus docker image
    - Dockerfile
    ```
    FROM prom/prometheus
    ADD prometheus.yml /etc/prometheus/
    ```
    - Build this docker image and run
    ```
    docker build -t my-prometheus .
    docker run -p 9090:9090 my-prometheus
    ```