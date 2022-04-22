package com.nudt.demo_02.service.Impl;

import com.nudt.demo_02.entity.UmsAdmin;
import com.nudt.demo_02.entity.UmsPermission;
import com.nudt.demo_02.mapper.UmsAdminMapper;
import com.nudt.demo_02.service.UmsAdminService;
import com.nudt.demo_02.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return umsAdminMapper.selectUmsAdminByUsername(username);
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        if (umsAdmin.getUsername().isEmpty() || umsAdmin.getPassword().isEmpty()) {
            LOGGER.info("请输入用户名和密码...");
            return null;
        }

        if (getAdminByUsername(umsAdmin.getUsername()) != null) {
            LOGGER.info("用户名已存在!");
            return null;
        }

        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminMapper.insertUmsAdmin(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确！");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }
        catch (AuthenticationException e) {
            LOGGER.warn("登录异常: {}", e.getMessage());
        }

        return token;
    }

    @Override
    public List<UmsPermission> getAllPermission(Long adminId) {
        return umsAdminMapper.selectAllPermissionById(adminId);
    }
}
