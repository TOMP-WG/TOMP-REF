FROM python:3.6-alpine

LABEL org.opencontainers.image.authors="evdbelt@dat.nl" tomp.version="1.3.0"

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY requirements.txt /usr/src/app/

RUN pip3 install connexion[swagger-ui]
RUN pip3 install --no-cache-dir -r requirements.txt

# patch connexion
COPY ./patch/parameter.py /usr/local/lib/python3.6/site-packages/connexion/decorators/parameter.py

COPY . /usr/src/app

EXPOSE 80

ENTRYPOINT ["python3"]
CMD ["-m", "swagger_server"]