FROM golang:1.12

WORKDIR /go/src/forumpost-microservice

# install dependencies
RUN go get -u google.golang.org/grpc
RUN go get -u github.com/golang/protobuf/protoc-gen-go
RUN go get go.mongodb.org/mongo-driver/mongo
RUN go get github.com/google/uuid

# copy the source tree
COPY ./proto ./proto
COPY ./scripts ./scripts
COPY ./server ./server

# build
WORKDIR /go/src/forumpost-microservice/server/forumpost
RUN go build main.go forum.go post.go

# run
CMD ["./main"]