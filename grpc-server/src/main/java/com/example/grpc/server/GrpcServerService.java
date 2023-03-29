package com.example.grpc.server;

import com.example.grpc.lib.HelloGrpc;
import com.example.grpc.lib.HelloReply;
import com.example.grpc.lib.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends HelloGrpc.HelloImplBase {
    @Override
    public void sayHello(final HelloRequest req, final StreamObserver<HelloReply> responseObserver) {
        final HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
