package com.elasticsearch.synonym.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.RequestConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	private static RestHighLevelClient client = null;

	public CreateIndexResponse createIndex(String indexName) {
		if (client == null) {
			client = getElasticClient();
		}
		flushIndex(indexName);
		return createNewIndex(indexName);
	}

	public DeleteIndexResponse deleteIndex(String indexName) {
		try {
			DeleteIndexRequest request = new DeleteIndexRequest(indexName);
			request.timeout(TimeValue.timeValueMinutes(2));
			request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
			request.indicesOptions(IndicesOptions.lenientExpandOpen());
			return client.indices().delete(request, RequestOptions.DEFAULT);
		} catch (ElasticsearchException exception) {
			if (exception.status() == RestStatus.NOT_FOUND) {
				exception.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private CreateIndexResponse createNewIndex(String indexName) {
		try {
			CreateIndexRequest request = new CreateIndexRequest(indexName);
			request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
			if (indexName.startsWith("x")) {
				request.mapping("tweet", getXContentMappingType());
			} else {
				request.mapping("tweet", getMappingType());
			}
			request.alias(new Alias("twitter_alias").filter(QueryBuilders.termQuery("user", "kimchy")));
			request.timeout(TimeValue.timeValueMinutes(2));
			request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
			request.waitForActiveShards(ActiveShardCount.DEFAULT);
			CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
			return createIndexResponse;
		} catch (Exception e) {
			return null;
		}
	}

	private Map<String, Object> getMappingType() {
		Map<String, Object> jsonMap = new HashMap<>();
		Map<String, Object> message = new HashMap<>();
		message.put("type", "text");
		Map<String, Object> properties = new HashMap<>();
		properties.put("message", message);
		Map<String, Object> tweet = new HashMap<>();
		tweet.put("properties", properties);
		jsonMap.put("tweet", tweet);
		return jsonMap;
	}

	private XContentBuilder getXContentMappingType() throws IOException {
		XContentBuilder builder = XContentFactory.jsonBuilder();
		builder.startObject();
		{
			builder.startObject("tweet");
			{
				builder.startObject("properties");
				{
					builder.startObject("message");
					{
						builder.field("type", "text");
					}
					builder.endObject();
				}
				builder.endObject();
			}
			builder.endObject();
		}
		builder.endObject();
		return builder;
	}

	public boolean flushIndex(String indexName) {
		try {
			client.indices().flush(new FlushRequest(indexName), RequestOptions.DEFAULT);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private RestHighLevelClient getElasticClient() {
		if (client == null) {
			List<HttpHost> hosts = new ArrayList<HttpHost>();
			String protocol = "http";
			Header[] headers = new Header[1];
			List<String> endPoints = new ArrayList<>();
			endPoints.add("localhost:9200");
			headers[0] = new BasicHeader("Content-Type", "application/json");
			endPoints.stream().forEach(point -> {
				String[] endPoint = point.split(":");
				hosts.add(new HttpHost(endPoint[0], Integer.parseInt(endPoint[1]), protocol));
			});

			HttpHost[] hostArray = new HttpHost[hosts.size()];
			for (int i = 0; i < hosts.size(); i++) {
				hostArray[i] = (HttpHost) hosts.get(i);
			}

			RestClientBuilder clientBuilder = RestClient.builder(hostArray).setDefaultHeaders(headers)
					.setMaxRetryTimeoutMillis(120000);
			clientBuilder.setRequestConfigCallback(new RequestConfigCallback() {
				@Override
				public Builder customizeRequestConfig(Builder requestConfigBuilder) {
					return requestConfigBuilder.setConnectionRequestTimeout(0);
				}
			});
			client = new RestHighLevelClient(clientBuilder);
		}
		return client;
	}

}
