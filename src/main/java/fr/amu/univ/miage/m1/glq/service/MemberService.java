package fr.amu.univ.miage.m1.glq.service;

import fr.amu.univ.miage.m1.glq.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberService {
    Map<String, Member> members = new HashMap<String, Member>();
    int memberIdCounter = 1;

    public MemberService() {
    }

    public Map<String, Member> getMembers() {
        return members;
    }

    /**
     * Ajoute un membre à la bibliothèque.
     */
    public String addMember(String firstName, String lastName, String email, String type) {
        String id = "M" + String.format("%05d", memberIdCounter++);
        Member member = new Member(id, firstName, lastName, email, type);
        members.put(id, member);
        System.out.println("Membre ajouté : " + member);
        return id;
    }

    public Member getMember(String id) {
        return members.get(id);
    }

    public Member getMemberByEmail(String email) {
        for (Member member : members.values()) {
            if (member.getEmail() != null && member.getEmail().equals(email)) {
                return member;
            }
        }
        return null;
    }

    public List<Member> getAllMembers() {
        return new ArrayList<Member>(members.values());
    }

    public void updateMember(Member member) {
        if (members.containsKey(member.getId())) {
            members.put(member.getId(), member);
        }
    }

    public void deleteMember(String id) {
        members.remove(id);
    }
}