package ${package}.services;

import ${package}.entities.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TestService {

	public Test getTest(String name) {
		Optional<Test> test = Test.find("name", name).firstResult();
		return test.isPresent() ? test.get() : new Test(0, "", "")
	}

	@Transactional
	public Test createTest(int id, String name, Integer value) {
		Test test = Test(id, name, value);
		test.persist()
		return test;
	}

	@Transactional
	public void deleteTest(int id) {
		Test test = Test(id);
		test.delete();
	}
	
}
