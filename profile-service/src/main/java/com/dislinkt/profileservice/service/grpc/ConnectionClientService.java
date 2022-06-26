package com.dislinkt.profileservice.service.grpc;

import com.dislinkt.Profile;
import com.dislinkt.ProfileServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class ConnectionClientService {

    @GrpcClient("connection-service")
    ProfileServiceGrpc.ProfileServiceStub asynchronousClient;

    public List<String> getFollowerRequests(String userId) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Profile profileRequest = Profile.newBuilder().setId(userId).build();
        final List<String> response = new ArrayList<>();
        asynchronousClient.getFollowerRequests(profileRequest, new StreamObserver<Profile>() {
            @Override
            public void onNext(Profile profile) {
                response.add(profile.getId());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }

    public List<String> getFollowing(String userId) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Profile profileRequest = Profile.newBuilder().setId(userId).build();
        final List<String> response = new ArrayList<>();
        asynchronousClient.getFollowing(profileRequest, new StreamObserver<Profile>() {
            @Override
            public void onNext(Profile profile) {
                response.add(profile.getId());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }

    public List<String> getFollowers(String userId) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Profile profileRequest = Profile.newBuilder().setId(userId).build();
        final List<String> response = new ArrayList<>();
        asynchronousClient.getFollowers(profileRequest, new StreamObserver<Profile>() {
            @Override
            public void onNext(Profile profile) {
                response.add(profile.getId());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }


}
