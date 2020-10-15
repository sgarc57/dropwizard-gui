FROM  azul/zulu-openjdk:11.0.7

ENV APP=/opt/app/
WORKDIR ${APP}

COPY target ${APP}

COPY config ${APP}/config

COPY start.sh ${APP}

COPY example.keystore ${APP}

RUN chmod 755 ${APP}start.sh

ENTRYPOINT ["sh", "start.sh"]

EXPOSE 8080/tcp
EXPOSE 8443/tcp
EXPOSE 8081/tcp
EXPOSE 8444/tcp
