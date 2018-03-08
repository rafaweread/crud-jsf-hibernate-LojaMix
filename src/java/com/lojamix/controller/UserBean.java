package com.lojamix.controller;  
import com.lojamix.dao.UserDAO;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.ViewScoped;  
import java.util.List;  
import com.lojamix.model.User;
import java.io.Serializable;  
import org.primefaces.event.RowEditEvent;  
import javax.faces.context.FacesContext;  
import javax.faces.application.FacesMessage;  
import org.primefaces.context.RequestContext;  
/** 
 * 
 * @author Rafael 
 */  
@ManagedBean(name = "userBean")  
@ViewScoped  
public class UserBean implements Serializable  
{  
    private List < User > usersList;  
    private List < User > searchList;  
    private List < User > searchByRecordNoList;  
    private String selectUser;
    
    UserDAO userDao = new UserDAO();  
    User user = new User();  
    User newuser = new User();  
    public List < User > getUsers()  
    {  
        usersList = userDao.AllUsers();  
        int count = usersList.size();  
        return usersList;  
    }  
    public void addUser()  
    {  
        String Remark = newuser.getRemark();  
        Integer userId = 0;  
        userId = userDao.getId();  
        newuser.setId(userId);  
        String Id = Integer.toString(newuser.getId());  
        newuser.setRecordNo(Integer.toString(userId));  
        userDao.add(newuser);  
        System.out.println("Usuário salvo com sucesso.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação salva", "Usuário salvo com sucesso.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        newuser = new User();  
    }  
    public void changeUser(User user)  
    {  
        this.user = user;  
    }  
    public void UpdateUser(User user)  
    {  
        String Name = user.getName();  
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Name", Name);  
        RequestContext.getCurrentInstance().showMessageInDialog(message1);  
        userDao.update(user);  
        System.out.println("Usuário salvo com sucesso.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação salva", "Usuário salvo com sucesso.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        user = new User();  
    }  
    public void deleteUser(User user)  
    {  
        String Name = user.getName();  
         
        userDao.delete(user);  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Registro deletado com sucesso");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
    public void searchbyRecordno()  
    {  
        searchByRecordNoList = userDao.SearchByRecordNo(this.selectUser);  
        int count = searchByRecordNoList.size();  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Um registro selecionado:", Integer.toString(count));  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
    public User getUser()  
    {  
        return user;  
    }  
    public void setUser(User user)  
    {  
        this.user = user;  
    }  
    public User getNewuser()  
    {  
        return newuser;  
    }  
    public void setNewuser(User newuser)  
    {  
        this.newuser = newuser;  
    }  
    public List < User > getUsersList()  
    {  
        return usersList;  
    }  
    public void setUsersList(List < User > usersList)  
    {  
        this.usersList = usersList;  
    }  
    public List < User > getSearchList()  
    {  
        return searchList;  
    }  
    public void setSearchList(List < User > searchList)  
    {  
        this.searchList = searchList;  
    }  
    public List < User > getSearchByRecordNoList()  
    {  
        return searchByRecordNoList;  
    }  
    public void setSearchByRecordNoList(List < User > searchByRecordNoList)  
    {  
        this.searchByRecordNoList = searchByRecordNoList;  
    }  
    public void onRowEdit(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage(" Nenhum registro editado", ((User) event.getObject()).getRecordNo());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        User editeduser = (User) event.getObject();  
        userDao.update(editeduser);  
    }  
    public void onCancel(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage("Edição cancelada");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        usersList.remove((User) event.getObject());  
    }  

    public String getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(String selectUser) {
        this.selectUser = selectUser;
    }
    
    
}  