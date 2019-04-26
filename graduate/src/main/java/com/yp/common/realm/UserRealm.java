package com.yp.common.realm;
import com.yp.common.pojo.Permission;
import com.yp.common.pojo.Role;
import com.yp.common.pojo.User;
import com.yp.common.service.PermissionService;
import com.yp.common.service.RoleService;
import com.yp.common.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther TyCoding
 * @date 2018/7/18
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
     @Autowired
     private RoleService roleService;
     @Autowired
     private PermissionService permissionService;
    /**
     * 权限校验
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限校验--执行了doGetAuthorizationInfo...");
        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.selectOneUserByName(username);
        int id=user.getUserId();
        System.out.println("用户id"+id);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //注意这里的setRoles和setStringPermissions需要的都是一个Set<String>类型参数
        Set<String> role = new HashSet<String>();
        List<Role> roles = roleService.selectAllRoleById(id);
         for (Role r : roles){
            role.add(r.getName());
         }
        authorizationInfo.setRoles(role);
         Set<String> permission = new HashSet<String>();
         List<Permission> permissions =permissionService.selctAllPermissionByUserId(id);
         for (Permission p : permissions){
            permission.add(p.getName());   //权限的描述
             System.out.print("输出的权限id"+p.getId());
        }
        authorizationInfo.setStringPermissions(permission);
         return authorizationInfo;
    }

    /**
     * 身份校验
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份校验--执行了goGetAuthenticationInfo...");

        String username = (String) token.getPrincipal();

        User user = userService.selectOneUserByName(username);
        System.out.println("获得的值是"+user.getUserName());
        if (user == null) {
            throw new UnknownAccountException(); //没有找到账号
        }


        //交给AuthenticationRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getUserPwd(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()), //salt=username+salt
                getName() //realm name
        );

        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
