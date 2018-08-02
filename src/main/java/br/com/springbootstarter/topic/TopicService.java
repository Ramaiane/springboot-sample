 package br.com.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("Java", "Core", " Description"),
			new Topic("JavaScript", "JavaScript", " Description")
			));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics=  new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
			
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
