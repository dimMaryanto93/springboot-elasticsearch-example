package com.maryanto.dimas.example.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.properties.elasticsearch.host}")
    private String elasticsearchHost;
    @Value("${elasticsearch.properties.elasticsearch.port}")
    private Integer elasticsearchPort;
    @Value("${elasticsearch.cluster-name}")
    private String elasticsearchClusterName;

    @Bean
    public Client client() throws UnknownHostException {
        Settings elasticsearchSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("cluster.name", elasticsearchClusterName).build();

        TransportClient client = TransportClient.builder()
                .settings(elasticsearchSettings)
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(
                                InetAddress.getByName(elasticsearchHost),
                                elasticsearchPort)
                );
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client);
    }

}
