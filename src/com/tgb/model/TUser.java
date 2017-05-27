package  com.tgb.model;  
  
import java.io.Serializable;
/**
 * TUser瀹炰綋绫�
 * @author 
 * @date   2017-05-27
 */
public   class  TUser extends BaseEntity implements  Serializable{  
    private  String userId;  
    private  String userAge;  
    private  String userName;  
    private  String email;  
    private  String permission;  
    private  String password;  
      
    public   void  setUserId(String userId){  
        this.userId=userId;  
    }  
      
    public  String getUserId(){  
        return   this.userId;  
    }  
    public   void  setUserAge(String userAge){  
        this.userAge=userAge;  
    }  
      
    public  String getUserAge(){  
        return   this.userAge;  
    }  
    public   void  setUserName(String userName){  
        this.userName=userName;  
    }  
      
    public  String getUserName(){  
        return   this.userName;  
    }  
    public   void  setEmail(String email){  
        this.email=email;  
    }  
      
    public  String getEmail(){  
        return   this.email;  
    }  
    public   void  setPermission(String permission){  
        this.permission=permission;  
    }  
      
    public  String getPermission(){  
        return   this.permission;  
    }  
    public   void  setPassword(String password){  
        this.password=password;  
    }  
      
    public  String getPassword(){  
        return   this.password;  
    }  

	public TUser(){}
	public TUser(
 		String userId,
 		String userAge,
 		String userName,
 		String email,
 		String permission,
 		String password
						){
			super();
			this.userId = userId;
			this.userAge = userAge;
			this.userName = userName;
			this.email = email;
			this.permission = permission;
			this.password = password;
	}
}  