package io.conduktor.demos.kafka.opensearch;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;

import java.net.URI;

public class OpenSearchConsumer {
    public static void main(String[] args) {

        /*
        public static RestHighLevelClient createOpenSearchClient () {
            String connString = "http://localhost:9200";

            // we build a URI from the connection string
            RestHighLevelClient restHighLevelClient;
            URI connUri = URI.create(connString);

            // extract login information if exists
            String userInfo = connUri.getUserInfo();

            if (userInfo == null) {
                // REST client withouth security
                restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(connUri.getHost())));
            } else {
                String[] auth = userInfo.split(":");

                CredentialsProvider cp = new BasicCredentialsProvider();
                cp.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(auth[0], auth[1]));
                /*
                restHighLevelClient = new RestHighLevelClient(
                        RestClient.builder(new HttpHost(connUri.getHost(), connUri.getPort(), connUri.getScheme())).
                                setHttpClientConfigCallback(
                                        httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultCredentialsProvider()
                                ));


    }

}
*/


        // first create an OpenSearch Client

        // create our Kafka Client

        // main code topic

        //
    }
}
