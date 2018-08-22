package com.example.demo.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("1", "A", "AAA"), new Topic("2", "B", "AAB"), new Topic("3", "C", "AAC")));

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(topic -> topic.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		getTopics().add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
