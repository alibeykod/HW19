package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.BusinessException;
import ir.maktabsharif.exception.InvalidDataException;
import ir.maktabsharif.exception.MemberNotFoundException;
import ir.maktabsharif.model.Member;
import ir.maktabsharif.repository.MemberRepository;
import ir.maktabsharif.repository.impl.MemberRepositoryImpl;
import ir.maktabsharif.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import javax.swing.text.html.parser.Entity;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }



    @Override
    public void save(Member member) {
        validation(member);
        memberRepository.save(member);
    }

    @Override
    public void update(Member member) {
        validation(member);
        memberRepository.update(member);
    }

    @Override
    public void delete(Long id) throws BusinessException {
        memberRepository.delete(id);
    }

    @Override
    public Member findById(Long id) throws BusinessException {
        return memberRepository.findById(id).orElseThrow(
                ()-> new MemberNotFoundException("Member Not Found ")
        );
    }

    private void validation(Member member){
        if (member.getFullName() == null || member.getFullName().isBlank()){
            throw new InvalidDataException("Member Name Can Not Be Null Or Empty");
        }
        if (member.getPhoneNumber() == null || member.getPhoneNumber().isBlank()){
            throw new InvalidDataException("Member Phone Number Can Not Be Null Or Empty");
        }
    }
}
