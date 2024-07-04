FROM postgres:13


ENV POSTGRES_USER=mamda
ENV POSTGRES_PASSWORD=mamdavsmcma
ENV POSTGRES_DB=yassir

EXPOSE 5432


CMD ["postgres"]
