package example.hello;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String args[]) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(12345)
                .addService(new HelloServiceImpl())
                .build();

        server.start();

        System.out.println("Server Start! : " + server.getPort());

        server.awaitTermination();;
    }

}
