package com.bwas.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwas.entity.Person;
import com.bwas.entity.Phonenumber;
import com.bwas.repo.IPersonRepository;
import com.bwas.repo.IPhoneNuberRepository;

@Service
public class OtoMAssocationService implements IIOToMAssocationMapping {
	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNuberRepository phoneRepo;

	@Override
	public void saveDataUsingParesnt() {

		Person p1 = new Person("Raja", "Hyderabad");

		Phonenumber ph1 = new Phonenumber(9999954544l, "JIO", "Office");
		Phonenumber ph2 = new Phonenumber(9666665455l, "vi", "personal");
		p1.setContactDetails(Set.of(ph1, ph2));
		ph1.setPersonInfo(p1);
		ph2.setPersonInfo(p1);
		personRepo.save(p1);

		System.out.println("Person and Phone Numbers added sucessfully");
	}

	@Override
	public void saveDataUsingChild() {

		Phonenumber ph1 = new Phonenumber(899989988l, "Airtel", "office");
		Phonenumber ph2 = new Phonenumber(7894556565l, "JIO", "Home");

		Person person = new Person("Rahul", "Kolkata");
		ph1.setPersonInfo(person);
		ph2.setPersonInfo(person);
		person.setContactDetails(Set.of(ph1, ph2));
		phoneRepo.save(ph1);
		phoneRepo.save(ph2);
	}

	@Override
	public void loadDataUsingParent() {
		Iterable<Person> list = personRepo.findAll();
		list.forEach(per -> {
			System.out.println("Parest  " + per);
			Set<Phonenumber> ph = per.getContactDetails();
			System.out.println("Count::" + ph.size());
			ph.forEach(pho -> {
				System.out.println("Child::" + pho.getMobileNo());
			});
		});

	}

	@Override
	public void loadDataUsingChild() {
		List<Phonenumber> list = phoneRepo.findAll();
		list.forEach(p -> {
			System.out.println("phonrNumber" + p);
			Person per = p.getPersonInfo();
			System.out.println(per);
		});

	}

	@Override
	public String deleteByPerson(Integer pid) {
		Optional<Person> opt = personRepo.findById(pid);
		if (opt.isPresent()) {
			personRepo.deleteById(pid);
			return pid + " Person Is deleted Sucessfully";
		}
		return "Invalid" + pid;
	}

	@Override
	public String deleteAllPhoneNumberOfPerson(Integer personId) {

		Person per = personRepo.getReferenceById(personId);
		if (per != null) {
			Set<Phonenumber> child = per.getContactDetails();
			for (Phonenumber ph : child) {
				ph.setPersonInfo(null);
			}

			phoneRepo.deleteAll(child);
			return per.getPid() + "Phone Numbers of " + personId + "  Is Deleted";
		} else {
			return "Inavlid " + personId;
		}

	}

	@Override
	public void addingNewChildExstingParent(int id) {

		Person per = personRepo.getReferenceById(id);
		if (per != null) {
			Set<Phonenumber> set = per.getContactDetails();

			Phonenumber ph = new Phonenumber(888888888l, "bsnl", "office");
			ph.setPersonInfo(per);
			set.add(ph);
			personRepo.save(per);
			System.out.println("New Child is added in the exsiting Parent");
		} else {
			System.out.println(id + " person not found for operation");
		}

	}
}
