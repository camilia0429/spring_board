package com.fantasy.commons;

import com.fantasy.commons.constants.Role;
import com.fantasy.entities.Member;
import com.fantasy.models.member.MemberInfo;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberUtil {

    @Autowired
    private HttpSession session;

    public boolean isLogin() {

        return getMember() != null;
    }

    public boolean isAdmin() {

        return isLogin() || getMember().getRoles() == Role.ADMIN;
    }

    public MemberInfo getMember() {
        MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
        return memberInfo;
    }

    public Member getEntity() {
        if(isLogin()) {
            Member member = new ModelMapper().map(getMember(), Member.class);
            return member;
        }
        return null;
    }
}
