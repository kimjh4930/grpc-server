package example.hello;

import example.HelloReply;
import example.HelloRequest;
import example.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloReply reply = HelloReply.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }
}
