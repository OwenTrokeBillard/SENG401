FROM rust:1.43

# install rustfmt
RUN rustup component add rustfmt

# create a new empty shell project
WORKDIR /usr/src
RUN USER=root cargo new --bin comments-microservice
WORKDIR /usr/src/comments-microservice

# copy over manifests
COPY ./Cargo.toml ./Cargo.toml

# cache the dependencies
RUN cargo build --release
RUN rm src/*.rs

# copy the source tree
COPY ./proto ./proto
COPY ./build.rs ./build.rs
COPY ./src ./src

# build for release
RUN cargo build --release
RUN cargo install --path .
CMD ["comments-microservice"]

# todo: Find a way to cache [build-dependencies] as well