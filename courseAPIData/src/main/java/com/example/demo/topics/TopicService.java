package com.example.demo.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@SuppressWarnings("unused")
	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("1", "A", "AAA"), new Topic("2", "B", "AAB"), new Topic("3", "C", "AAC")));

	public List<Topic> getTopics() {
		// return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(String id) {
		// return topics.stream().filter(topic ->
		// topic.getId().equalsIgnoreCase(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		// getTopics().add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { Topic t = topics.get(i); if
		 * (t.getId().equalsIgnoreCase(id)) { topics.set(i, topic); } }
		 */
		System.out.println("Hi");
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		// topics.removeIf(t -> t.getId().equals(id));
	}

}
