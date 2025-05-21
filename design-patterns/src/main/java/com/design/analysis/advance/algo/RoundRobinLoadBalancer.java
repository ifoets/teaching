package com.design.analysis.advance.algo;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer {
    private final List<String> servers;
    private final AtomicInteger currentIndex;

    public RoundRobinLoadBalancer(List<String> servers) {
        if (servers == null || servers.isEmpty()) {
            throw new IllegalArgumentException("Server list cannot be null or empty");
        }
        this.servers = servers;
        this.currentIndex = new AtomicInteger(0);
    }

    public String getNextServer() {
        int index = Math.abs(currentIndex.getAndIncrement() % servers.size());
        return servers.get(index);
    }

    // Example usage
    public static void main(String[] args) {
        List<String> servers = List.of("Server-A", "Server-B", "Server-C");
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer(servers);

        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + " goes to " + loadBalancer.getNextServer());
        }
    }
}