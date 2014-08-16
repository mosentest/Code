package test;

import java.util.Date;
import java.util.List;

import org.mu.opencomm.code.entity.Tag;
import org.mu.opencomm.code.repository.TagRepository;

public class Test {

	public static void main(String[] args) {
		TagRepository tagRepository = new TagRepository();
//		tagRepository.save(createTag("Spring Framework", 10000, "java"));
//		tagRepository.save(createTag("Spring", 10120, "java"));
//		tagRepository.save(createTag("Hadoop", 20000, "java"));
//		tagRepository.save(createTag("HBase", 30000, "java"));
//		tagRepository.save(createTag("Apache Foundation", 40000, "java"));
//		tagRepository.save(createTag("SpringMVC", 20000, "java"));
//		tagRepository.save(createTag("Pig", 10000, "java"));
//		tagRepository.save(createTag("Zookeeper", 1000, "java"));
//		tagRepository.save(createTag("Hive", 10000, "java"));
//		tagRepository.save(createTag("Apache commons", 50000, "java"));
//		tagRepository.save(createTag("JVM", 3000, "java"));
//		tagRepository.save(createTag("ElasticSearch", 6000, "java"));
//		tagRepository.save(createTag("Android", 50000, "java"));
//		tagRepository.save(createTag("NoSQL", 20000, "java"));
//		tagRepository.save(createTag("mongoDB", 20000, "java"));
//		tagRepository.save(createTag("TDD", 10000, "java"));
//		tagRepository.save(createTag("slf4j", 10000, "java"));
//		tagRepository.save(createTag("log4j", 10000, "java"));
//		tagRepository.save(createTag("postgreSQL", 15000, "java"));
//		tagRepository.save(createTag("openGL", 10000, "cpp"));
//		tagRepository.save(createTag("Boost", 10000, "cpp"));
//		tagRepository.save(createTag("QT", 15000, "cpp"));
		List<Tag> tags = tagRepository.findByType("java");
		for (Tag tag : tags) {
			System.out.println(tag.getTag() + ":" + tag.getNTags());
		}
	}
	
	private static Tag createTag(String tag, long nTags, String type) {
		Tag instance = new Tag();
		instance.setTag(tag);
		instance.setNTags(nTags);
		instance.setType(type);
		instance.setDate(new Date());
		return instance;
	}
	
}
