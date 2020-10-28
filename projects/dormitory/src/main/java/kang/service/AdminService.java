package kang.service;


import kang.mapper.AdminMapper;
import kang.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String username, String password) {
        return adminMapper.login(username, password);
    }
}
